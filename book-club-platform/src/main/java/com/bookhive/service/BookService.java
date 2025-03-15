package com.bookhive.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.bookhive.dto.book.BookResponseDto;
import com.bookhive.dto.book.DiscussionResponseDto;
import com.bookhive.dto.book.RecommendationResponseDto;
import com.bookhive.dto.book.ReviewResponseDto;
import com.bookhive.entity.Book;
//import com.bookhive.entity.Chapter;
import com.bookhive.repository.BookRepository;
//import com.bookhive.repository.ChapterRepository;

import io.minio.BucketExistsArgs;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.http.Method;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final MinioClient minioClient;

    @Value("${minio.bucket-name}")
    private String bucketName;

    @PostConstruct
    public void createBucketIfNotExists() {
        try {
            boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!bucketExists) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create bucket: " + e.getMessage());
        }
    }

    /**
     * Upload book and chapters to MinIO
     */
    public void uploadBook(MultipartFile file, String title, String author, String genre,
            String language, Integer publishedYear, Double rating,
            MultipartFile coverImage) throws Exception {

        // Save cover image to MinIO and get the URL
        String bookUrl = uploadToMinio(file, title);
        String coverImageUrl = uploadToMinio(coverImage, title + "_cover");

        // Save book details to the database
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setLanguage(language);
        book.setPublishedYear(publishedYear);
        book.setRating(rating);
        book.setCoverImageUrl(coverImageUrl);
        book.setBookUrl(bookUrl);
        bookRepository.save(book);
    }

    /**
     * Upload any file to MinIO and return the URL
     */
    private String uploadToMinio(MultipartFile file, String objectName) throws Exception {
        // Extract file extension from content type
        String contentType = file.getContentType();
        String extension = getExtensionFromContentType(contentType);

        if (extension == null) {
            throw new IllegalArgumentException("Unsupported file type: " + contentType);
        }

        String fileName = objectName + "_" + System.currentTimeMillis() + "." + extension;
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(fileName)
                        .stream(file.getInputStream(), file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build());

        return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .bucket(bucketName)
                        .object(fileName)
                        .method(Method.GET)
                        .build());
    }

    // Helper method to extract file extension based on content type
    private String getExtensionFromContentType(String contentType) {
        if (contentType == null)
            return null;

        switch (contentType) {
            case "application/pdf":
                return "pdf";
            case "image/jpeg":
                return "jpg";
            case "image/png":
                return "png";
            case "image/gif":
                return "gif";
            case "text/plain":
                return "txt";
            case "application/vnd.openxmlformats-officedocument.wordprocessingml.document":
                return "docx";
            case "application/msword":
                return "doc";
            default:
                return null;
        }
    }

    public BookResponseDto findBookByTitle(String title) {
        Book book = bookRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("Book not found with title: " + title));

        BookResponseDto response = new BookResponseDto();
        response.setBookId(book.getBookId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setGenre(book.getGenre());
        response.setLanguage(book.getLanguage());
        response.setRating(book.getRating());
        response.setPublishedYear(book.getPublishedYear());
        response.setCoverImageUrl(book.getCoverImageUrl());
        response.setBookUrl(book.getBookUrl());
        // Map Discussions
        response.setDiscussions(book.getDiscussions().stream()
                .map(discussion -> {
                    DiscussionResponseDto dto = new DiscussionResponseDto();
                    dto.setDiscussionId(discussion.getDiscussionId());
                    dto.setContent(discussion.getContent());
                    dto.setUsername(discussion.getUser().getUsername());
                    return dto;
                })
                .collect(Collectors.toList()));

        // Map Reviews
        response.setReviews(book.getReviews().stream()
                .map(review -> {
                    ReviewResponseDto dto = new ReviewResponseDto();
                    dto.setReviewId(review.getReviewId());
                    dto.setContent(review.getContent());
                    dto.setUsername(review.getUser().getUsername());
                    return dto;
                })
                .collect(Collectors.toList()));

        // Map Recommendations
        response.setRecommendations(book.getRecommendations().stream()
                .map(recommendation -> {
                    RecommendationResponseDto dto = new RecommendationResponseDto();
                    dto.setRecommendationId(recommendation.getRecommendationId());
                    dto.setRecommendedBookTitle(recommendation.getBook().getTitle());
                    return dto;
                })
                .collect(Collectors.toList()));
        return response;
    }
}

package com.bookhive.service;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MakeBucketArgs;
import io.minio.BucketExistsArgs;
import io.minio.http.Method;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MinioService {

    private final MinioClient minioClient;

    // ✅ Upload using InputStream
    public String uploadFile(InputStream inputStream, String bucketName, String folderName, String fileName, String contentType, long size) throws Exception {
        ensureBucketExists(bucketName);

        String extension = getExtensionFromContentType(contentType);
        String objectPath = buildObjectPath(folderName, fileName, extension);

        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectPath)
                        .stream(inputStream, size, -1)
                        .contentType(contentType)
                        .build()
        );

        return getPresignedUrl(bucketName, objectPath);
    }

    // ✅ Upload using MultipartFile
    public String uploadFile(MultipartFile file, String bucketName, String folderName) throws Exception {
        ensureBucketExists(bucketName);

        String extension = getExtensionFromFilename(file.getOriginalFilename());
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        String objectPath = buildObjectPath(folderName, fileName, extension);

        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectPath)
                        .stream(file.getInputStream(), file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build()
        );

        return getPresignedUrl(bucketName, objectPath);
    }

    // ✅ Ensure the bucket exists or create a new one
    private void ensureBucketExists(String bucketName) throws Exception {
        boolean isBucketExists = minioClient.bucketExists(
                BucketExistsArgs.builder()
                        .bucket(bucketName)
                        .build()
        );

        if (!isBucketExists) {
            minioClient.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(bucketName)
                            .build()
            );
        }
    }

    // ✅ Build object path with folderName and extension
    private String buildObjectPath(String folderName, String fileName, String extension) {
        String baseName = fileName.replaceAll("\\s+", "_");
        String finalName = extension != null ? baseName + extension : baseName;

        return (folderName != null && !folderName.isEmpty())
                ? folderName + "/" + finalName
                : finalName;
    }

    // ✅ Generate pre-signed URL for direct access
    private String getPresignedUrl(String bucketName, String objectPath) throws Exception {
        return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .bucket(bucketName)
                        .object(objectPath)
                        .method(Method.GET)
                        .build()
        );
    }

    // ✅ Extract extension from content type
    private String getExtensionFromContentType(String contentType) {
        if (contentType == null) return "";
        return switch (contentType) {
            case "application/pdf" -> ".pdf";
            case "image/jpeg" -> ".jpg";
            case "image/png" -> ".png";
            case "text/plain" -> ".txt";
            case "application/json" -> ".json";
            default -> "";
        };
    }

    // ✅ Extract extension from file name
    private String getExtensionFromFilename(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(f.lastIndexOf(".")))
                .orElse("");
    }
}

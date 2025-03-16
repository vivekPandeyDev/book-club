package com.bookhive.service;

import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookhive.entity.Book;
import com.bookhive.entity.Chapter;
import com.bookhive.repository.ChapterRepository;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ChapterService {

    private final ChapterRepository chapterRepository;
    private final MinioService minioService;

    @Transactional
    public void extractAndSaveChapters(InputStream inputStream, Book book) throws Exception {
        try (PDDocument document = PDDocument.load(inputStream)) {
            // Step 1: Extract Index Page to Get Chapter Names and Page Numbers
            Map<String, Integer> index = extractIndex(document);

            for (Map.Entry<String, Integer> entry : index.entrySet()) {
                String chapterTitle = entry.getKey();
                int startPage = entry.getValue();
                int endPage = findNextChapterStartPage(index, startPage, document.getNumberOfPages());

                String chapterContent = extractChapterContent(document, startPage, endPage);

                // Step 2: Upload to MinIO
                //String chapterUrl = minioService.uploadChapterToMinio(chapterTitle, chapterContent);

                // Step 3: Save to Database
                Chapter chapter = new Chapter();
                chapter.setTitle(chapterTitle);
                //chapter.setContentUrl(chapterUrl);
                chapter.setBook(book);
                chapterRepository.save(chapter);
            }
        }
    }

    private Map<String, Integer> extractIndex(PDDocument document) throws Exception {
        PDFTextStripper pdfStripper = new PDFTextStripper();
        pdfStripper.setStartPage(1);
        pdfStripper.setEndPage(5); // Index is usually within the first 5 pages

        String content = pdfStripper.getText(document);

        Map<String, Integer> index = new LinkedHashMap<>();
        String[] lines = content.split("\n");

        for (String line : lines) {
            if (line.matches(".*\\s+\\d+$")) {
                String[] parts = line.trim().split("\\s+(?=\\d+$)");
                if (parts.length == 2) {
                    String title = parts[0].trim();
                    int pageNumber = Integer.parseInt(parts[1].trim());
                    index.put(title, pageNumber);
                }
            }
        }

        return index;
    }

    private int findNextChapterStartPage(Map<String, Integer> index, int currentPage, int totalPages) {
        return index.values().stream()
                .filter(page -> page > currentPage)
                .findFirst()
                .orElse(totalPages + 1);
    }

    private String extractChapterContent(PDDocument document, int startPage, int endPage) throws Exception {
        PDFTextStripper pdfStripper = new PDFTextStripper();
        pdfStripper.setStartPage(startPage);
        pdfStripper.setEndPage(endPage - 1);
        return pdfStripper.getText(document);
    }
}

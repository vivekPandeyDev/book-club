package com.bookhive.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.bookhive.dto.page.BookPageDto;
import com.bookhive.entity.Book;

@Component
public class BookPageExtractor {

    public List<BookPageDto> extractPages(MultipartFile file, Book book) throws IOException {
        List<BookPageDto> pages = new ArrayList<>();

        // Example logic to split text file into pages (Modify based on file type)
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            int pageNumber = 1;
            StringBuilder pageContent = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                pageContent.append(line).append("\n");

                // Simulate page break after every 500 characters
                if (pageContent.length() >= 500) {
                    pages.add(createBookPageDto(book, pageNumber++, pageContent.toString()));
                    pageContent.setLength(0);
                }
            }

            // Save remaining content as last page
            if (pageContent.length() > 0) {
                pages.add(createBookPageDto(book, pageNumber, pageContent.toString()));
            }
        }
        return pages;
    }

    private BookPageDto createBookPageDto(Book book, int pageNumber, String content) {
        BookPageDto bookPageDto = new BookPageDto();
        bookPageDto.setPageNumber(pageNumber);
        bookPageDto.setPageTitle("Page " + pageNumber);
        bookPageDto.setPageUrl("book/" + book.getBookId() + "/page/" + pageNumber);
        bookPageDto.setBookId(book.getBookId());
        bookPageDto.setBookName(book.getTitle());
        bookPageDto.setContent(content);
        return bookPageDto;
    }
}

package com.example.hw3.util;

import com.example.hw3.dto.BookDto;
import com.example.hw3.entity.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class BookConventor {
    public Book BookDtoToBook(BookDto bookDto){
        return Book.builder()
                .id(bookDto.getBook_id())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .numberOfPages(bookDto.getNumber_of_pages())
                .build();
    }

    public BookDto BookToBookDto(Book book){
        return BookDto.builder()
                .book_id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .number_of_pages(book.getNumberOfPages())
                .build();
    }
}

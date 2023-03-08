package com.example.hw3.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "book")
@NamedQueries({
        @NamedQuery(name = "Book.findAll",
                query = "select b from Book b")
})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "author", nullable = false, length = 50)
    private String author;

    @Column(name = "number_of_pages", nullable = false)
    private Integer numberOfPages;

}
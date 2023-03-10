package com.example.hw3.dao;

import com.example.hw3.entity.Book;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

@Stateless
public class BookDao {
    @PersistenceContext
    private EntityManager em;
    public List<Book> findAll(){
        return em.createNamedQuery("Book.findAll", Book.class).getResultList();
    }

    public void add(Book book) {
        em.persist(book);
    }

    public void deleteById(int id) {
        Optional<Book> book = Optional.ofNullable(findById(id));
        book.ifPresent(value -> em.remove(value));
    }

    public Book findById(int id) {
        return em.find(Book.class, id);
    }

    public void update(Book editedBook) {
        Book book = findById(editedBook.getId());
        book.setTitle(editedBook.getTitle());
        book.setAuthor(editedBook.getAuthor());
        book.setNumberOfPages(editedBook.getNumberOfPages());
        em.merge(book);
    }
}

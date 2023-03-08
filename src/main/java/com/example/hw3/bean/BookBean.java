package com.example.hw3.bean;

import com.example.hw3.dao.BookDao;
import com.example.hw3.dto.BookDto;
import com.example.hw3.entity.Book;
import com.example.hw3.util.BookConventor;
import jakarta.ejb.EJB;
import jakarta.el.MethodExpression;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BookBean implements Serializable {
    @Getter @Setter
    private BookDto bookDto;
    @EJB
    private BookDao bookDao;

    @Inject
    private BookConventor bookConventor;
    public BookBean() {
        bookDto = new BookDto();
    }

    public List<Book> getBooks(){
        return bookDao.findAll();
    }

    public void add() {
        bookDao.add(bookConventor.BookDtoToBook(bookDto));
        bookDto = new BookDto();
    }

    public void delete(int id) {
        bookDao.deleteById(id);
        bookDto = new BookDto();
    }
}

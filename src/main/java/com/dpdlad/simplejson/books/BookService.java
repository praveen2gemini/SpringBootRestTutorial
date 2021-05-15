package com.dpdlad.simplejson.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@PropertySource("classpath:application.properties")
@Component
public class BookService {

    @Autowired
    Environment environment;

    public List<Book> getAllBooks() {
        return Arrays.asList(new Book(101L, "Ramayanam", "Kambar"),
                new Book(102L, "Ramayanam version2", "Kambar2"),
                new Book(103L, "Indian Polity", "Laxmikanth"),
                new Book(104L, "Indian Polity by edition2", "Mugil"),
                new Book(105L, "Indian Stock market", "Anand Srinivasan"));
    }

    public List<Book> getBooksByName(String bookName) {
        List<Book> allBooks = getAllBooks();
        List<Book> filteredBooks = new ArrayList<>();
        allBooks.forEach(book -> {
            if (book.bookName.equalsIgnoreCase(bookName) || book.bookName.contains(bookName)) {
                filteredBooks.add(book);
            }
        });
        return filteredBooks;
    }

    private Book getOptionalBook(long bookId) {
        List<Book> allBooks = getAllBooks();
        Book foundBook = null;
        for (Book book : allBooks) {
            if (book.bookId == bookId) {
                foundBook = book;
                break;
            }
        }
        return foundBook;
    }

    public Book getBooksById(long bookId) {
        Book foundBook = getOptionalBook(bookId);
        if (null == foundBook) {
            long defaultBookId = environment.getProperty("default.bookId", Long.class);
            System.out.println("default.bookId" + defaultBookId);
            foundBook = getOptionalBook(defaultBookId);
        }
        return foundBook;
    }
}

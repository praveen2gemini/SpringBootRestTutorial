package com.dpdlad.simplejson.books;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class BookService {

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

    public Book getBooksById(long bookId) {
        List<Book> allBooks = getAllBooks();
        AtomicReference<Book> filteredBook = new AtomicReference<>();
        for (Book book : allBooks) {
            if (book.bookId == bookId) {
                filteredBook.set(book);
                break;
            }
        }
        return filteredBook.get();
    }
}

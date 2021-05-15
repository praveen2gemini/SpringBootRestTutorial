package com.dpdlad.simplejson.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/booksById")
    public Book getBooksById(@RequestParam(value = "bookId") long bookId) {
        return bookService.getBooksById(bookId);
    }

    @GetMapping("/booksByName")
    public List<Book> getBooksByName(@RequestParam(value = "bookName") String bookName) {
        return bookService.getBooksByName(bookName);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/booksByIdOrName")
    public List<Book> getBooksByIdOrName(@RequestBody Book book) {
        return bookService.getBooksByName(book.bookName);
    }

}

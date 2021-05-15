package com.dpdlad.simplejson.books;

public class Book {

    public Book(long bookId, String bookName, String authorName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
    }

    String bookName;

    public String getBookName() {
        return bookName;
    }

    public long getBookId() {
        return bookId;
    }

    public String getAuthorName() {
        return authorName;
    }

    long bookId;
    String authorName;
}

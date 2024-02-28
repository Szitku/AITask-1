package org.generativeaitask.controller;

import org.generativeaitask.domain.Book;
import org.generativeaitask.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveOrUpdateBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id); // Ensure the ID matches
        return bookService.saveOrUpdateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/search/title")
    public List<Book> searchBooksByTitle(@RequestParam String keyword) {
        return bookService.searchBooksByTitle(keyword);
    }

    @GetMapping("/search/author")
    public List<Book> searchBooksByAuthorName(@RequestParam String keyword) {
        return bookService.searchBooksByAuthorName(keyword);
    }

    @GetMapping("/search/genre")
    public List<Book> searchBooksByGenreName(@RequestParam String keyword) {
        return bookService.searchBooksByGenreName(keyword);
    }
}

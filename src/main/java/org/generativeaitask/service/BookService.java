package org.generativeaitask.service;

import org.generativeaitask.domain.Book;
import org.generativeaitask.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    public final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book saveOrUpdateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooksByTitle(String keyword) {
        return bookRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public List<Book> searchBooksByAuthorName(String keyword) {
        return bookRepository.findByAuthorNameContainingIgnoreCase(keyword);
    }

    public List<Book> searchBooksByGenreName(String keyword) {
        return bookRepository.findByGenreNameContainingIgnoreCase(keyword);
    }
}

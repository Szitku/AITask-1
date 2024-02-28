package org.generativeaitask;

import org.generativeaitask.domain.Book;
import org.generativeaitask.repository.BookRepository;
import org.generativeaitask.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testGetAllBooks() {
        // Mocking repository to return a list of books
        List<Book> books = Arrays.asList(new Book(), new Book());
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.getAllBooks();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetBookById() {
        // Mocking repository to return a book
        Book book = new Book();
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Book result = bookService.getBookById(1L);

        assertNotNull(result);
    }

    @Test
    public void testSaveOrUpdateBook() {
        // Mocking repository to save a book
        Book book = new Book();
        when(bookRepository.save(book)).thenReturn(book);

        Book result = bookService.saveOrUpdateBook(book);

        assertNotNull(result);
    }

    @Test
    public void testDeleteBook() {
        // Deleting a book should not throw an exception
        assertDoesNotThrow(() -> bookService.deleteBook(1L));
    }
}

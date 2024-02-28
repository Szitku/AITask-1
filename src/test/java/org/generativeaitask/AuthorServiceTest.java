package org.generativeaitask;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.generativeaitask.domain.Author;
import org.generativeaitask.repository.AuthorRepository;
import org.generativeaitask.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @Test
    public void testGetAllAuthors() {
        // Mocking repository to return a list of authors
        List<Author> authors = Arrays.asList(new Author(), new Author());
        when(authorRepository.findAll()).thenReturn(authors);

        List<Author> result = authorService.getAllAuthors();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetAuthorById() {
        // Mocking repository to return an author
        Author author = new Author();
        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));

        Author result = authorService.getAuthorById(1L);

        assertNotNull(result);
    }

    @Test
    public void testSaveOrUpdateAuthor() {
        // Mocking repository to save an author
        Author author = new Author();
        when(authorRepository.save(author)).thenReturn(author);

        Author result = authorService.saveOrUpdateAuthor(author);

        assertNotNull(result);
    }

    @Test
    public void testDeleteAuthor() {
        // Deleting an author should not throw an exception
        assertDoesNotThrow(() -> authorService.deleteAuthor(1L));
    }

}


package org.generativeaitask;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.generativeaitask.domain.Genre;
import org.generativeaitask.repository.GenreRepository;
import org.generativeaitask.service.GenreService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GenreServiceTest {

    @Mock
    private GenreRepository genreRepository;

    @InjectMocks
    private GenreService genreService;

    @Test
    public void testGetAllGenres() {
        // Mocking repository to return a list of genres
        List<Genre> genres = Arrays.asList(new Genre(), new Genre());
        when(genreRepository.findAll()).thenReturn(genres);

        List<Genre> result = genreService.getAllGenres();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetGenreById() {
        // Mocking repository to return a genre
        Genre genre = new Genre();
        when(genreRepository.findById(1L)).thenReturn(Optional.of(genre));

        Genre result = genreService.getGenreById(1L);

        assertNotNull(result);
    }

    @Test
    public void testSaveOrUpdateGenre() {
        // Mocking repository to save a genre
        Genre genre = new Genre();
        when(genreRepository.save(genre)).thenReturn(genre);

        Genre result = genreService.saveOrUpdateGenre(genre);

        assertNotNull(result);
    }

    @Test
    public void testDeleteGenre() {
        // Deleting a genre should not throw an exception
        assertDoesNotThrow(() -> genreService.deleteGenre(1L));
    }
}
package org.generativeaitask.repository;

import org.generativeaitask.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByAuthorNameContainingIgnoreCase(String authorName);
    List<Book> findByGenreNameContainingIgnoreCase(String genreName);
}

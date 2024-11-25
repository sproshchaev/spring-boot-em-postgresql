package com.example.spring_boot_em_postgresql;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import static io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureEmbeddedDatabase(provider = ZONKY)
@ActiveProfiles("test")
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void checkPostgresVersion() {
        System.out.println(bookRepository.getPgVersion());
    }

    @Test
    void testSaveAndFindBook() {
        // Create a new book
        Book book = new Book(null, "Test Book", "Test Author");
        bookRepository.save(book);

        // Find all books and verify
        List<Book> books = bookRepository.findAll();
        assertFalse(books.isEmpty());

        Book savedBook = books.get(0);
        assertEquals("Test Book", savedBook.getTitle());
        assertEquals("Test Author", savedBook.getAuthor());
    }

    @Test
    void testDeleteBook() {
        // Create a new book
        Book book = new Book(null, "Book to Delete", "Author");
        bookRepository.save(book);

        List<Book> booksBeforeDelete = bookRepository.findAll();
        assertFalse(booksBeforeDelete.isEmpty());

        // Delete the book
        bookRepository.deleteById(booksBeforeDelete.get(0).getId());

        // Verify deletion
        List<Book> booksAfterDelete = bookRepository.findAll();
        assertTrue(booksAfterDelete.isEmpty());
    }
}
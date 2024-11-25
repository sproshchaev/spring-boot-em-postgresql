package com.example.spring_boot_em_postgresql;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Book> rowMapper = (rs, rowNum) -> new Book(
            rs.getLong("id"),
            rs.getString("title"),
            rs.getString("author")
    );

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getPgVersion() {
        return jdbcTemplate.queryForObject("SELECT version();", String.class);
    }


    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM library.books", rowMapper);
    }

    public Book findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM library.books WHERE id = ?",
                rowMapper,
                id
        );
    }

    public void save(Book book) {
        if (book.getId() == null) {
            jdbcTemplate.update(
                    "INSERT INTO library.books (title, author) VALUES (?, ?)",
                    book.getTitle(), book.getAuthor()
            );
        } else {
            jdbcTemplate.update(
                    "UPDATE library.books SET title = ?, author = ? WHERE id = ?",
                    book.getTitle(), book.getAuthor(), book.getId()
            );
        }
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM library.books WHERE id = ?", id);
    }
}

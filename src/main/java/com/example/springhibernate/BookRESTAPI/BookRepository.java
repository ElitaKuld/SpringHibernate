package com.example.springhibernate.BookRESTAPI;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findByAuthor(String author);
}

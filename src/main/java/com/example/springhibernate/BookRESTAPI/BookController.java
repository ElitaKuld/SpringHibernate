package com.example.springhibernate.BookRESTAPI;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {
    private final BookRepository repo;
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    @RequestMapping("books")
    public List<Book> getAllBooks(){
        log.info("All books returned");
        log.error("All books returned in ERROR message");
        log.warn("All books returned in WARNING message");
        log.debug("All books returned in DEBUG message");
        return repo.findAll(); //plockar ut alla böcker som finns i vår book-tabell
    }

    //curl http://localhost:8080/books/add -H "Content-Type:application/json" -d "{\"title\":\"Pippi Langstrump\", \"author\":\"Astrid Lindgren\"}" -v
    @PostMapping("books/add")
    public List<Book> addBook(@RequestBody Book book){
        repo.save(book); //spara ner en bok
        return repo.findAll(); //plockar ut alla böcker som finns i vår book-tabell
    }

    @RequestMapping("books/{id}")
    public Book getBookById(@PathVariable long id){
        return repo.findById(id).get();
    }

    @RequestMapping("books/{author}/author")
    public List<Book> getBookByAuthor(@PathVariable String author){
        return repo.findByAuthor(author);
    }

    @RequestMapping("books/{id}/delete")
    public List<Book> deleteBookById(@PathVariable long id){
        repo.deleteById(id); //ta bort den bok som har en speciell id
        log.info("Book with id " + id + " is deleted");
        return repo.findAll();
    }
}

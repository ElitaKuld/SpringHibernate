package com.example.springhibernate.BookRESTAPI;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    @RequestMapping("books")
    public List<Book> getAllBooks(){
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
        return repo.findAll();
    }
}

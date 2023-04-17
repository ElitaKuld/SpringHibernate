package com.example.springhibernate;

import com.example.springhibernate.BookRESTAPI.Book;
import com.example.springhibernate.BookRESTAPI.BookRepository;
import com.example.springhibernate.KompisRESTAPI.Kompis;
import com.example.springhibernate.KompisRESTAPI.KompisRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateApplication.class, args);
    }

    //Om man vill att data ska skickas in varje gång man kör applikationen:

    /*
    @Bean
    public CommandLineRunner demo(BookRepository repository){
        return (args) -> {
            // save a few books
            repository.save(new Book("Sagan om ringen", "Tolkien"));
            repository.save(new Book("Sagan om två tornen", "Tolkien"));
            repository.save(new Book("Sagan om konungens återkomst", "Tolkien"));
            repository.save(new Book("Ronja Rövardotter", "Astrid Lindgren"));
            repository.save(new Book("Lotta på Bråkmakargatan", "Astrid Lindgren"));
        };
    }*/

    @Bean
    public CommandLineRunner demo(KompisRepository repository){
        return (args) -> {
            // save a few friends
            repository.save(new Kompis("Cooper", "Interstellar 5", "762217282"));
            repository.save(new Kompis("Oliver", "London 12", "762217963"));
            repository.save(new Kompis("Matthew", "Beach 7", "761237282"));
            repository.save(new Kompis("Lilly", "Hogwarts 18", "762126582"));
            repository.save(new Kompis("Jesse", "Talamasca 77", "764563322"));
        };
    }
}

package com.example.springhibernate.BookRESTAPI;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Lombok
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)// tom konstruktor
@Entity
public class Book {
    @Id
    @GeneratedValue
    protected long id;
    protected String title;
    protected String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

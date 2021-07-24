package com.api.book.bootrestbook.controllers;

import com.api.book.bootrestbook.entities.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookControllers 
{
 
    @GetMapping("/books")
    public Book getBooks()
    {
        Book book = new Book();
        book.setId(2365);
        book.setTitle("Java complete reference");
        book.setAuthor("xyz");
        
        return book;
    }
    
}

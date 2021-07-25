package com.api.book.bootrestbook.controllers;

import java.util.List;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookControllers 
{
    @Autowired
    private BookService bookService;
    
    //get all book mapping
    @GetMapping("/books")
    public List<Book> getBooks()
    {       
        List<Book> allboBooks = this.bookService.getAllboBooks(); 
        return allboBooks;
    }
    
    //get by id mapping
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") int id)
    {
        Book bookById = this.bookService.getBookById(id);
        return bookById;

    }

    //create maping
    @PostMapping("/books/add")
    public Book addBook(@RequestBody Book book)
    {
        Book b =this.bookService.addBook(book);
        return b;
    }

       
    //delete a book
    @DeleteMapping("/books/delete/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId)
    {
        this.bookService.deleteBook(bookId);
        
    }
    
    //update mapping
    @PutMapping("/books/update/{bookId}")
    public Book updateBook(@PathVariable("bookId") int bookById,@RequestBody Book book)
    {
        this.bookService.updateBook(bookById,book);
        return book;
    }
}

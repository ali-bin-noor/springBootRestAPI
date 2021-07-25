package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Book>> getBooks()
    {       
        List<Book> list = this.bookService.getAllboBooks(); 
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }
    
    //get by id mapping
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id)
    {
        Book book = this.bookService.getBookById(id);
        if(book==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));

    }

    //create maping
    @PostMapping("/books/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book)
    {
        Book b=null;
        try
        {
            b = this.bookService.addBook(book);
            System.out.println(b);
            return ResponseEntity.of(Optional.of(b));
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
        
    }

       
    //delete a book
    @DeleteMapping("/books/delete/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId)
    {
        try 
        {
            this.bookService.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } 
        catch (Exception e) 
        {
         e.printStackTrace();
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }
    
    //update mapping
    @PutMapping("/books/update/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable("bookId") int bookById,@RequestBody Book book)
    {
        try 
        {
            this.bookService.updateBook(bookById,book);
            return ResponseEntity.ok().body(book);   
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }
}

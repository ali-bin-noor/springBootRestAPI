package com.api.book.bootrestbook.services;


import java.util.ArrayList;
import java.util.List;

import com.api.book.bootrestbook.entities.Book;

import org.springframework.stereotype.Service;

@Service
public class BookService 
{
    private static List<Book> list = new ArrayList<>();
    
    static
    {
        list.add(new Book(12,"Java Complete Reference", "XYZ"));
        list.add(new Book(36,"Head First to Java", "ABC"));
        list.add(new Book(52,"Thing in Java", "LMN"));
    }

    //get all books
    public List<Book> getAllboBooks()
    {
        return list;
    }

    //get book byId
    public Book getBookById(int id)
    {
        Book book=null;
        book=list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }
    
}

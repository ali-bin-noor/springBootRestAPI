package com.api.book.bootrestbook.services;


import java.util.List;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService 
{
    @Autowired
    private BookRepository bookRepository;
    // private static List<Book> list = new ArrayList<>();
    
    // static
    // {
    //     list.add(new Book(12,"Java Complete Reference", "XYZ"));
    //     list.add(new Book(36,"Head First to Java", "ABC"));
    //     list.add(new Book(52,"Thing in Java", "LMN"));
    // }

    //get all books
    public List<Book> getAllboBooks()
    {
       List<Book> list = (List<Book>) this.bookRepository.findAll();
       return list;
    }

    //get book byId
    public Book getBookById(int id)
    {
        Book book=null;
    try
        {
        //book=list.stream().filter(e->e.getId()==id).findFirst().get();
         book = this.bookRepository.findById(id);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    return book;
        
    }

    //adding new book
    public Book addBook(Book book)
    {
        Book result = this.bookRepository.save(book);
        return result;

    }

    //delete book
    public void deleteBook(int bookId)
    {
        // list=list.stream().filter(book->{
        //     if(book.getId()!=bookId)
        //     {
        //         return true;
        //     }
        //     else
        //     {
        //         return false;
        //     }
        // }).collect(Collectors.toList());
        this.bookRepository.deleteById(bookId);

    }

    //update the book 
    public void updateBook(int bookId,Book book)
    {
    //    list= list.stream().map(b->{
    //         if(b.getId()==bookId)
    //         {
    //             b.setTitle(book.getTitle());
    //             b.setAuthor(book.getAuthor());
    //         }
    //         return b;
    //     }).collect(Collectors.toList());
    book.setId(bookId);
    this.bookRepository.save(book);
    }
    
}

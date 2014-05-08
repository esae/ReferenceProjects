/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.fhnw.bscwi.esae.lendingreferenceproject1.controller;

import ch.fhnw.bscwi.esae.lendingreferenceproject1.business.BookEJB;
import ch.fhnw.bscwi.esae.lendingreferenceproject1.domain.Book;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Named;


/**
 *
 * @author andreas.martin
 */
@Named
@SessionScoped
public class BookController implements Serializable{

    public BookController() {
    }
    @EJB
    private BookEJB bookEJB;
    private Book book;
    private List<Book> bookList;
    private HtmlDataTable bookHtmlDataTable;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBookList() {
        bookList = bookEJB.findBooks();
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
    
    public String prepareCreateBook()
    {
        this.book = new Book();
        return "newBookCase";
    }

    public String doCreateBook() {
        book = bookEJB.createBook(book);
        bookList = bookEJB.findBooks();
        return "listBooksCase";
    }
    
    public HtmlDataTable getBookHtmlDataTable() {
        return bookHtmlDataTable;
    }

    public void setBookHtmlDataTable(HtmlDataTable bookHtmlDataTable) {
        this.bookHtmlDataTable = bookHtmlDataTable;
    }
    
    public String prepareEditBook()
    {
        this.book = (Book) this.bookHtmlDataTable.getRowData();
        return "editBookCase";
    }
    
    public String doEditBook()
    {
        book=bookEJB.updateBook(book);
        bookList = bookEJB.findBooks();
        return "listBooksCase";
    }
    
    public String doDeleteBook()
    {
        this.book = (Book) this.bookHtmlDataTable.getRowData();
        bookEJB.deleteBook(book);
        book=new Book();
        bookList = bookEJB.findBooks();
        return "listBooksCase";
    }
    
}
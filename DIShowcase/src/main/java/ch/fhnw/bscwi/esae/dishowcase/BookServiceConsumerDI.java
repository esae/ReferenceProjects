/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.fhnw.bscwi.esae.dishowcase;

/**
 *
 * @author andreas.martin
 */
public class BookServiceConsumerDI {
    
    protected BookDAO bookDAO = null;
    
    public BookServiceConsumerDI(BookDAO bookDAO)
    {
        this.bookDAO = bookDAO;
    }
    
    public void createAJavaEEBook()
    {
        Book book = new Book();
        book.setTitle("Java EE - DI");
        book.setPrice(12.5F);
        book.setDescription("Java EE 6");
        book.setIsbn("1-4564-777-8");
        book.setNbOfPage(254);
        book.setIllustrations(Boolean.FALSE);
        bookDAO.createBook(book);
    } 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.fhnw.bscwi.esae.dishowcase;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author andreas.martin
 */
@Stateless
public class BookServiceConsumerEJB {
    
    @EJB @BookDAOEJB
    protected BookDAO bookDAO;
       
    public void createAJavaEEBook()
    {
        Book book = new Book();
        book.setTitle("Java EE - EJB");
        book.setPrice(12.5F);
        book.setDescription("Java EE 6");
        book.setIsbn("1-4564-777-8");
        book.setNbOfPage(254);
        book.setIllustrations(Boolean.FALSE);
        bookDAO.createBook(book);
    }   
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.fhnw.bscwi.esae.lendingreferenceproject1.business;

import ch.fhnw.bscwi.esae.lendingreferenceproject1.domain.Book;
import ch.fhnw.bscwi.esae.lendingreferenceproject1.domain.BookLending;
import ch.fhnw.bscwi.esae.lendingreferenceproject1.domain.Customer;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author andreas.martin
 */
@Stateless
public class BookLendingEJB {
    
    @PersistenceContext(unitName = "ch.fhnw.bscwi.esae_lending-reference-project-1_war_1.0-SNAPSHOTPU")
    private EntityManager em;


    public BookLending lendBook(Book book, Customer customer) {
        BookLending bookLending = new BookLending();
        bookLending.setBook(book);
        bookLending.setCustomer(customer);
        bookLending.setLendingDate(new GregorianCalendar().getTime());
        bookLending.setBookIsLended(true);
        em.persist(bookLending);
        return bookLending;
    }


    public BookLending returnBook(Book book, Customer customer) {      
        Query query = em.createNamedQuery("findOpenLendingByCustomerAndBookId");
        query.setParameter("book", book);
        query.setParameter("customer", customer);
        List<BookLending> bookLendings = query.getResultList();
        if(bookLendings.isEmpty())
            return null;
        BookLending bookLending = (BookLending) bookLendings.get(0);
        bookLending.setBookIsLended(false);
        bookLending.setReturnDate(new GregorianCalendar().getTime());
        em.persist(bookLending);
        return bookLending;
    }


    public List<BookLending> showAllLendings(Customer customer) {
        Query query = em.createNamedQuery("findLendingByCustomer");
        query.setParameter("customer", customer);
        List<BookLending> bookLendings = query.getResultList();
        if(bookLendings.isEmpty())
            return null;
        return bookLendings;
    }
    

    public List<Book> showAllNotLendedBooks()
    {
        Query query = em.createNamedQuery("findNotLendedBooks");
        List<Book> book = query.getResultList();
        if(book.isEmpty())
            return null;
        return book;
    }
    

    public void deleteBookLending(BookLending bookLending) {
        em.remove(em.merge(bookLending));
    }
    
}

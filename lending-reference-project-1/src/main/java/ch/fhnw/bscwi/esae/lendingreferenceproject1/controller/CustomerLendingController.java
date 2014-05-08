/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.fhnw.bscwi.esae.lendingreferenceproject1.controller;

import ch.fhnw.bscwi.esae.lendingreferenceproject1.business.BookLendingEJB;
import ch.fhnw.bscwi.esae.lendingreferenceproject1.domain.Book;
import ch.fhnw.bscwi.esae.lendingreferenceproject1.domain.BookLending;
import ch.fhnw.bscwi.esae.lendingreferenceproject1.domain.Customer;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Named;


/**
 *
 * @author andreas.martin
 */
@Named
@SessionScoped
public class CustomerLendingController implements Serializable{

    @EJB
    private BookLendingEJB bookLendingEJB;
    @ManagedProperty(value="#{customerController}")
    private CustomerController customerController;
    private List<BookLending> bookLendingList;
    private HtmlDataTable bookLendingHtmlDataTable;
    private BookLending bookLending;
    private List<Book> notLendedBookList;
    private HtmlDataTable notLendedBookHtmlDataTable;
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public HtmlDataTable getNotLendedBookHtmlDataTable() {
        return notLendedBookHtmlDataTable;
    }

    public void setNotLendedBookHtmlDataTable(HtmlDataTable notLendedBookHtmlDataTable) {
        this.notLendedBookHtmlDataTable = notLendedBookHtmlDataTable;
    }

    public List<Book> getNotLendedBookList() {
        this.notLendedBookList = bookLendingEJB.showAllNotLendedBooks();
        return notLendedBookList;
    }

    public void setNotLendedBookList(List<Book> notLendedBookList) {
        this.notLendedBookList = notLendedBookList;
    }

    public HtmlDataTable getBookLendingHtmlDataTable() {
        return bookLendingHtmlDataTable;
    }

    public void setBookLendingHtmlDataTable(HtmlDataTable bookLendingHtmlDataTable) {
        this.bookLendingHtmlDataTable = bookLendingHtmlDataTable;
    }

    public List<BookLending> getBookLendingList() {
        this.bookLendingList = bookLendingEJB.showAllLendings(customerController.getCustomer());
        return bookLendingList;
    }

    public void setBookLendingList(List<BookLending> bookLendingList) {
        this.bookLendingList = bookLendingList;
    }

    public CustomerController getCustomerController() {
        return customerController;
    }

    public void setCustomerController(CustomerController customerController) {
        this.customerController = customerController;
    }
    
    public String doEndLending()
    {
        this.bookLending = (BookLending) this.bookLendingHtmlDataTable.getRowData();
        bookLendingEJB.returnBook(bookLending.getBook(), customerController.getCustomer());
        getBookLendingList();
        getNotLendedBookList();
        return "customerLendingCase";
    }
    
    public String doLending()
    {
        this.book = (Book) this.notLendedBookHtmlDataTable.getRowData();
        bookLendingEJB.lendBook(book, customerController.getCustomer());
        getBookLendingList();
        getNotLendedBookList();
        return "customerLendingCase";
    }
    
    public String prepareLending()
    {
        customerController.setCustomer((Customer) customerController.getCustomerHtmlDataTable().getRowData());
        return "customerLendingCase";
    }
    
    public String doDeleteLending()
    {
        this.bookLending = (BookLending) this.bookLendingHtmlDataTable.getRowData();
        bookLendingEJB.deleteBookLending(bookLending);
        getBookLendingList();
        getNotLendedBookList();
        return "customerLendingCase";
    }
}

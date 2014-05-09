/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.fhnw.bscwi.esae.dishowcase;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author andreas.martin
 */
@Named
@RequestScoped
public class BookProcessor {
    
    protected BookServiceConsumerNoDI bookServiceConsumerNoDI;
    
    protected BookServiceConsumerDI bookServiceConsumerDI;
    
    @Inject
    protected BookServiceConsumerCDI bookServiceConsumerCDI;
    
    @Inject
    protected BookServiceConsumerEJB bookServiceConsumerEJB;

    public void execute() {
        bookServiceConsumerNoDI = new BookServiceConsumerNoDI();
        bookServiceConsumerNoDI.createAJavaEEBook();
        System.out.println("NoDI");
        
        BookDAO bookDAO = new BookServicePOJO();
        bookServiceConsumerDI = new BookServiceConsumerDI(bookDAO);
        bookServiceConsumerDI.createAJavaEEBook();
        System.out.println("DI");
        
        bookServiceConsumerCDI.createAJavaEEBook();
        System.out.println("CDI");
        
        bookServiceConsumerEJB.createAJavaEEBook();
        System.out.println("EJB");
    }
}

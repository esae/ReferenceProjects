/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.fhnw.bscwi.esae.dishowcase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author andreas.martin
 */
public class BookServicePOJO implements BookDAO{

    @Override
    public Book createBook(Book book) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch.fhnw.bscwi.esae_DIShowcase_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin(); 
        em.getTransaction();
        em.persist(book);
        tx.commit();
        em.close();
        emf.close();
        return book;
    }  
}

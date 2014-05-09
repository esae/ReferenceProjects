/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.fhnw.bscwi.esae.dishowcase;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andreas.martin
 */
@Stateless
@BookDAOEJB
public class BookServiceEJB implements BookDAO{
    
    @PersistenceContext(unitName = "ch.fhnw.bscwi.esae_DIShowcase_war_1.0-SNAPSHOTPU_JTA")
    EntityManager em;

    @Override
    public Book createBook(Book book) {
        em.persist(book);
        return book;
    } 
}

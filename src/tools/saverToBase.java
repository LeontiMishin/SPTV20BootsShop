/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.History;
import entity.Purchase;
import entity.Shoe;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import interfaces.Keeping;

/**
 *
 * @author user
 */
public class saverToBase {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPTV20LibraryPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    @Override
    public void saveShoes(List<Shoe> shoes) {
        tx.begin();
            for (int i = 0; i < shoes.size(); i++) {
                if(shoes.get(i).getId() == null){
                    em.persist(shoes.get(i));
                }else{
                    em.merge(shoes.get(i));
                }
            }
        tx.commit();
    }

    @Override
    public List<Shoe> loadShoes() {
        List<Shoe> shoes = null;
        try {
            shoes = em.createQuery("SELECT book FROM Book book")
                .getResultList();
        } catch (Exception e) {
            shoes = new ArrayList<>();
        }
        return shoes;
    }

    @Override
    public void saveReaders(List<Purchase> readers) {
        tx.begin();
            for (int i = 0; i < readers.size(); i++) {
                if(readers.get(i).getId() == null){
                    em.persist(readers.get(i));
                }
            }
        tx.commit();
    }

    @Override
    public List<Reader> loadReaders() {
       List<Reader> readers = null;
        try {
            readers = em.createQuery("SELECT reader FROM Reader reader")
                .getResultList();
        } catch (Exception e) {
            readers = new ArrayList<>();
        }
        return readers;
    }

    @Override
    public void saveHistories(List<History> histories) {
        tx.begin();
            for (int i = 0; i < histories.size(); i++) {
                if(histories.get(i).getId() == null){
                    em.persist(histories.get(i));
                }
            }
        tx.commit();
    }

    @Override
    public List<History> loadHistories() {
        List<History> histories = null;
        try {
            histories = em.createQuery("SELECT history FROM History history")
                .getResultList();
        } catch (Exception e) {
            histories = new ArrayList<>();
        }
        return histories;
    }

    @Override
    public void saveAuthors(List<Author> authors) {
        tx.begin();
            for (int i = 0; i < authors.size(); i++) {
                if(authors.get(i).getId() == null){
                    em.persist(authors.get(i));
                }
            }
        tx.commit();
    }

    @Override
    public List<Author> loadAuthors() {
        try {
            return em.createQuery("SELECT author FROM Author author")
                .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Customer;
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
public class SaverToBase implements Keeping{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BootsShopPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    @Override
    public void saveHistories(List<History> histories) {
        tx.begin();
        for (int i = 0; i < histories.size(); i++) {
            if (histories.get(i).getId() == null) {
                em.persist(histories.get(i));
            }
        }
        tx.commit();
    }

    @Override
    public List<History> loadHistories() {
        List<History> histories = null;
        try {
            return em.createQuery("SELECT h FROM History h").getResultList();
        } catch (Exception e) {
            histories = new ArrayList<>();
        }
        return histories;
    }

    @Override
    public void saveShoeses(List<Shoe> shoeses) {
        tx.begin();
        for (int i = 0; i < shoeses.size(); i++) {
            if (shoeses.get(i).getId() == null) {
                em.persist(shoeses.get(i));
            }
        }
        tx.commit();
    }

    @Override
    public List<Shoe> loadShoeses() {
        List<Shoe> shoes = null;
        try {
            return em.createQuery("SELECT m FROM Model m").getResultList();
        } catch (Exception e) {
            shoes = new ArrayList<>();
        }
        return shoes;
    }

    @Override
    public void saveCustomers(List<Customer> customers) {
                tx.begin();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == null) {
                em.persist(customers.get(i));
            }
        }
        tx.commit();
    }

    @Override
    public List<Customer> loadCustomers() {
        List<Customer> buyers = null;
        try {
            return em.createQuery("SELECT b FROM Buyer b").getResultList();
        } catch (Exception e) {
            buyers = new ArrayList<>();
        }
        return buyers;
    }
}

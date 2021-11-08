/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author user
 */
public class Purchase implements Serializable {
    private Shoe shoe;
    private Customer customer;
    private Date givenShoe;
    private double generalMoney;

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Date getGivenShoe() {
        return givenShoe;
    }

    public void setGivenShoe(Date givenShoe) {
        this.givenShoe = givenShoe;
    }

    public double getGeneralMoney() {
        return generalMoney;
    }

    public void setGeneralMoney(double generalMoney) {
        this.generalMoney = generalMoney;
    }
    
    
}
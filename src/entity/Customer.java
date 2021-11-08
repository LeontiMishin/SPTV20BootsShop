/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Customer implements Serializable {
    private String buyerFirstName;
    private String buyerLastName;
    private String buyerPhone;
    private double buyerMoney;

    public String getBuyerFirstName() {
        return buyerFirstName;
    }

    public void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    public String getBuyerLastName() {
        return buyerLastName;
    }

    public void setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }


    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public double getBuyerMoney() {
        return buyerMoney;
    }

    public void setBuyerMoney(double buyerMoney) {
        this.buyerMoney = buyerMoney;
    }
    @Override
    public String toString() {
        return "покупатель: " + buyerFirstName +" "+ buyerLastName + ", Tel.: " + buyerPhone + ", кол. денег: " + buyerMoney +" евро"+' ';
    }
    
}
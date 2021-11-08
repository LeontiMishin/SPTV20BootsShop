/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Leonti
 */
public class History {
    private Sneaker sneaker;
    private Buyer buyer;
    private Date givenSneaker;
    private double generalMoney;
    
    public Sneaker getSneaker() {
        return sneaker;
    }

    public void setSneaker(Sneaker sneaker) {
        this.sneaker = sneaker;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Date getGivenSneaker() {
        return givenSneaker;
    }

    public void setGivenSneaker(Date givenSneaker) {
        this.givenSneaker = givenSneaker;
    }

}


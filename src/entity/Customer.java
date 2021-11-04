/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author user
 */
public class Customer {
    private String fName;
    private String lName;
    private int euro;

    public String getFname() {
        return fName;
    }

    public void setFname(String fName) {
        this.fName = fName;
    }

    public String getLname() {
        return lName;
    }

    public void setLname(String lName) {
        this.lName = lName;
    }

    public int getFunds() {
        return euro;
    }

    public void setFunds(int funds) {
        this.euro = funds;
    }
    @Override
    public String toString() {
        return "Customer{"
                + "First name=" + fName
                + ",\n Last name=" + lName
                + ",\n Euro=" + euro
                + "\n}";
    }
    
}
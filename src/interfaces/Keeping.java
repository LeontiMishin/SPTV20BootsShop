/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Customer;
import entity.Purchase;
import java.util.List;
import entity.Shoe;

/**
 *
 * @author Leonti
 */
public interface Keeping {
    public void saveShoeses(List<Shoe> shoeses);
    public List<Shoe> loadShoeses();
    public void saveCustomers(List<Customer> customers);
    public List<Customer> loadCustomers();
//    public void savePurchases(List<Purchase> purchases);
//    public List<Purchase> loadPurchases();
}

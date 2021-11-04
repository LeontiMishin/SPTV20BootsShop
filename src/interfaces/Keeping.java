/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Purchase;
import entity.Customer;
import java.util.List;
/**
 *
 * @author user
 */
public interface Keeping {
    public void saveModels(List<Model> costomers);
    public List<Model> loadModel();
    public void saveCostomers(List<Model> costomers);
    public List<Customer> loadReaders();
    public void saveHistories(List<Purchase> purchases);
    public List<Purchase> loadPurchases();
    
}

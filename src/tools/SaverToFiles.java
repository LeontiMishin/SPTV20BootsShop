/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import entity.Shoe;
import entity.Purchase;
import entity.Customer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Shoe;
import interfaces.Keeping;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Leonti
 */
public class SaverToFiles implements Keeping {
    
    @Override
    public void saveShoeses(List<Shoe> shoeses) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("shoeses");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(shoeses);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Нет файла shoeses", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        }
    }

    @Override
    public List<Shoe> loadShoeses() {
        List<Shoe> shoeses = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("shoeses");
            ois = new ObjectInputStream(fis);
            shoeses = (List<Shoe>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "shoeses еше не создан", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Ошибка чтения", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        }
        return shoeses;
    }

    @Override
    public void saveCustomers(List<Customer> customers) {
       FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("customers");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(customers);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Нет файла customers", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        }
    }

    @Override
    public List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("customers");
            ois = new ObjectInputStream(fis);
            customers = (List<Customer>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "customers еше не создан", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Ошибка чтения", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        }
        return customers;
    }
//   @Override
//    public void savePurchases(List<Purchase> purchases) {
//         FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            fos = new FileOutputStream("purchases");
//            oos = new ObjectOutputStream(fos);
//            oos.writeObject(purchases);
//            oos.flush();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Нет файла purchases", ex);
//        } catch (IOException ex) {
//            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
//        }
//    }

//    @Override
//    public List<Purchase> loadPurchases() {
//        List<Purchase> purchases = new ArrayList<>();
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        try {
//            fis = new FileInputStream("purchases");
//            ois = new ObjectInputStream(fis);
//            purchases = (List<Purchase>) ois.readObject();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Purchases еше не создан", ex);
//        } catch (IOException ex) {
//            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Ошибка чтения", ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
//        }
//        return purchases;
//    }
    
}
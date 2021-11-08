/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

import entity.Customer;
import entity.Purchase;
import entity.Shoe;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author artie
 */
public class App {
    Scanner scanner = new Scanner(System.in);
    List<Shoe> shoes = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();
    List<Purchase> purchases = new ArrayList<>();
    public void run() {
        int exit=0;
        do{
            System.out.println("Выберите задачу: ");
            System.out.println("0: Выход из программы");
            System.out.println("1: Добавить обувь");
            System.out.println("2: Список продаваемой обуви");
            System.out.println("3: Добавить покупателя");
            System.out.println("4: Список зарегистрированных покупателей");
            System.out.println("5: Покупка обуви");
            System.out.println("6: Доход магазина за все время работы");
            
            int menu = scanner.nextInt();
            scanner.nextLine();
            switch (menu){
                case 0:
                    exit++;
                    break;
                case 1:
                    addShoe();
                    break; 
                case 2:  
                    listModel();
                    break;
                case 3:
                    addCustomer();
                    break;
                case 4:
                    buyerList();
                    break;
                case 5:
                    addPurchase();
                    break;
                case 6:
                    income();
                    break;
            }
            
            }while(exit==0);
            System.out.println("Пока! :)");
        }
    
        private void addShoe(){
            System.out.println("Добавление обуви");
            Shoe shoe = new Shoe();
            System.out.print("Бренд: ");
            shoe.setBrand(scanner.nextLine());
            System.out.print("Модель: ");
            shoe.setModel(scanner.nextLine());
            System.out.print("Введите размер кроссовка: ");
            shoe.setSize(scanner.nextDouble()); scanner.nextLine();
            System.out.print("Цена модели: ");
            shoe.setPrice(scanner.nextDouble()); scanner.nextLine();
            System.out.println("Добавлена"+shoe.toString());
            shoes.add(shoe);
        }
        
        private void addCustomer(){
            System.out.print("Добавление покупателя");
            Customer customer = new Customer();
            System.out.println("Введите имя покупателя:");
            customer.setBuyerFirstName(scanner.nextLine());
            System.out.print("Введите фамилию покупателя:");
            customer.setBuyerLastName(scanner.nextLine());
            System.out.print("Введите номер телефона покупателя: ");
            customer.setBuyerPhone(scanner.nextLine());
            System.out.print("Введите количество денег у покупателя: ");
            customer.setBuyerMoney(scanner.nextDouble()); scanner.nextLine();
            System.out.println("Добавлен "+customer.toString());
            customers.add(customer);
        }

    private void listModel() {
        System.out.println("Список обуви");
        int n=0;
        for (int i = 0; i < shoes.size(); i++) {
            if(shoes.get(i)!=null){
                System.out.printf("%d. %s %s, размер: %.1f, цена: %.2f евро%n",
                i+1,
                shoes.get(i).getBrand(),
                shoes.get(i).getModel(),
                shoes.get(i).getSize(),
                shoes.get(i).getPrice()
                );
                n++;
            }
    }  
    if(n<1){
        System.out.println("Кроссовок нет!");
    }
    }      

    private void buyerList() {
        System.out.println("Список покупателей");
        int n=0;
            for (int i = 0; i < customers.size(); i++) {
                if(customers.get(i)!=null){
                System.out.printf("%d. %s %s, номер телефона: %s, деньги у покупателя: %.2f евро%n",
                i+1,
                customers.get(i).getBuyerFirstName(),
                customers.get(i).getBuyerLastName(),
                customers.get(i).getBuyerPhone(),
                customers.get(i).getBuyerMoney()
                );
                n++;
            }
        } 
    if(n<1){
        System.out.println("Покупателей нет!");
    }
    }

    private void addPurchase() {
        System.out.println("*ПОКУПКА ОБУВИ*"); 
    System.out.println("-----------------------------");
    sneakerList();
    System.out.print("Выберите нужную модель обуви:");
    int sneakerNum= scan.nextInt(); scan.nextLine();
    System.out.println("-----------------------------");
    buyerList();
    System.out.print("Выберите нужного покупателя: ");
    int buyerNum= scan.nextInt(); scan.nextLine();
    History history= new History();
    history.setSneaker(sneakers.get(sneakerNum-1));
    history.setBuyer(buyers.get(buyerNum-1));
    Calendar c = new GregorianCalendar();
    history.setGivenSneaker(c.getTime());
    if(history.getBuyer().getBuyerMoney()>=history.getSneaker().getSneakerPrice()){
        System.out.println("-----------------------------");
        System.out.printf("Кроссовки %s %s купил %s %s за %.2f евро %s%n",
        history.getSneaker().getSneakerFirm(),
        history.getSneaker().getSneakerModel(),
        history.getBuyer().getBuyerFirstName(),
        history.getBuyer().getBuyerLastName(),
        history.getSneaker().getSneakerPrice(),
        history.getGivenSneaker()
        );
        history.getBuyer().setBuyerMoney(history.getBuyer().getBuyerMoney()-history.getSneaker().getSneakerPrice());
        income.setGeneralMoney(income.getGeneralMoney()+history.getSneaker().getSneakerPrice());
        histories.add(history);
    }else{
        System.out.println("Этот пользователь не может совершить покупку, так как у него не хватает денег!");
}
}  

    private void income() {
        System.out.println("*ДОХОД МАГАЗИНА*");
        System.out.printf("Выручка магазина составляет: %.2f%n",income.getGeneralMoney());
    }
}
 
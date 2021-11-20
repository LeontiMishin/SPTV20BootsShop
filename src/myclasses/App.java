/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

import entity.Customer;
import entity.History;
import entity.Income;
import entity.Purchase;
import entity.Shoe;
import interfaces.Keeping;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import tools.SaverToFiles;
import tools.SaverToBase;

/**
 *
 * @author Leonti
 */
public class App {
    public static boolean toFile = false;
    private Scanner scanner = new Scanner(System.in);
    private List<Shoe> shoes = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Purchase> purchases = new ArrayList<>();
    private List<History> histories= new ArrayList<>();
    Income income = new Income();
    private Keeping keeper = new SaverToBase();
    
    public App(){
                if (toFile) {
            keeper = new SaverToFiles();
        }else{
            keeper = (Keeping) new SaverToBase();
        }
            
        shoes = keeper.loadShoeses();
        customers = keeper.loadCustomers();
        histories = keeper.loadHistories();
        
    }
    
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
            System.out.println("7: Добавить денег покупателю");
            System.out.println("8: Редактировать товар");
            System.out.println("9: Редактировать покупателя");
            
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
                case 7:
                   addMoney();
                   break;
                case 8:
                    changeShoe();
                    break;
                case 9:
                    changeCustomer();
                    break;
               default:
                   System.out.println("Выберите номер из списка!");
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
            keeper.saveShoeses(shoes);
            
        }
        
        private void addCustomer(){
            System.out.println("Добавление покупателя");
            Customer customer = new Customer();
            System.out.print("Введите имя покупателя: ");
            customer.setBuyerFirstName(scanner.nextLine());
            System.out.print("Введите фамилию покупателя: ");
            customer.setBuyerLastName(scanner.nextLine());
            System.out.print("Введите номер телефона покупателя: ");
            customer.setBuyerPhone(scanner.nextLine());
            System.out.print("Введите количество денег у покупателя: ");
            customer.setBuyerMoney(scanner.nextDouble()); scanner.nextLine();
            System.out.println("Добавлен "+customer.toString());
            customers.add(customer);
            keeper.saveCustomers(customers);
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
                System.out.printf("%d. %s %s, номер телефона: %s, денег у покупателя: %.2f евро%n",
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
        System.out.println("Покупка обуви"); 
        System.out.println("-----------------------------");
        listModel();
        System.out.print("Выберите нужную модель обуви: ");
        int shoeNum= scanner.nextInt(); scanner.nextLine();
        buyerList();
        System.out.println();
        System.out.print("Выберите нужного покупателя: ");
        int customerNum= scanner.nextInt(); scanner.nextLine();
        History history = new History();
        history.setShoe(shoes.get(shoeNum-1));
        history.setBuyer(customers.get(customerNum-1));
        Calendar c = new GregorianCalendar();
        history.setGivenShoe(c.getTime());
        if(history.getCustomer().getBuyerMoney()>=history.getSneaker().getPrice()){
            System.out.println("-----------------------------");
            System.out.printf("Кроссовки %s %s купил %s %s за %.2f евро %s%n",
            history.getSneaker().getBrand(),
            history.getSneaker().getModel(),
            history.getCustomer().getBuyerFirstName(),
            history.getCustomer().getBuyerLastName(),
            history.getSneaker().getPrice(),
            history.getGivenShoe()
            );
            history.getCustomer().setBuyerMoney(history.getCustomer().getBuyerMoney()-history.getSneaker().getPrice());
            income.setGeneralMoney(income.getGeneralMoney()+history.getSneaker().getPrice());
            histories.add(history);
        }else{
            System.out.println("Не хватает денег!");
        }
    }  

    private void income() {
        System.out.println("Доход магазина");
        System.out.printf("Выручка магазина: %.2f%n",income.getGeneralMoney());
    }

    private void addMoney() {
    System.out.println("Добавить денег ");
    buyerList();
    System.out.print("Выберите нужного покупателя: ");
    int choice= scanner.nextInt(); scanner.nextLine();
    System.out.print("Введите сколько денег вы хотите добавить этому покупателю: ");
    int add= scanner.nextInt(); scanner.nextLine();
    customers.get(choice-1).setBuyerMoney(customers.get(choice-1).getBuyerMoney()+add);
    }

    private void changeShoe() {
        
    }

    private void changeCustomer() {
        
    }
}
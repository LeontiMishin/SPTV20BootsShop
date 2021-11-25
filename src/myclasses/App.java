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
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
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
            keeper = new SaverToBase();
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
            shoe.setSize(scanner.nextInt()); scanner.nextLine();
            System.out.print("Цена модели: ");
            shoe.setPrice(scanner.nextInt()); scanner.nextLine();
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
            System.out.println( "Кроссовок нет!");
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
//                System.out.println("----- Список обуви -----");
//        int n=0;
//        for (int i = 0;i < shoes.size(); i++) {
//            if (shoes.get(i)!=null
//                    && shoes.get(i).getQuantity()>0) {
//                System.out.printf("%d Брэнд: %s, Название: %s, Размер: %d, Цена: %d, В наличии: %d.%n"
//                ,i+1
//                ,shoes.get(i).getBrand()
//                ,shoes.get(i).getName()
//                ,shoes.get(i).getSize()
//                ,shoes.get(i).getPrice()
//                ,shoes.get(i).getQuantity()
//                );
//            }
//            n++;
//        }
//    if (n<1) {
//        System.out.println("Нет обуви в наличии.");
//        return;
//    }
//        System.out.print("Выберите номер обуви: ");
//        int numberModel= getNumber();
//        String repeat="yes";
//        do{
//            System.out.println("0. Выход");
//            System.out.println("1. Изменить брэнд обуви");
//            System.out.println("2. Изменить название модели");
//            System.out.println("3. Изменить размер модели");
//            System.out.println("4. Изменить цену модели");
//            System.out.println("5. Изменить количество экземпляров");
//            System.out.println("Выберите номер параметра, который хотите изменить: ");
//            int num=getNumber();
//            switch(num){
//                case 0:
//                    repeat="no";
//                    break;
//                case 1:
//                    System.out.print("Введите новый брэнд обуви: ");
//                    String newBrand=scanner.nextLine();
//                    models.get(numberModel-1).setBrand(newBrand);
//                    saverToFiles.saveModels(models);
//                    break;
//                case 2:
//                    System.out.print("Введите новое название модели: ");
//                    String newName=scanner.nextLine();
//                    models.get(numberModel-1).setName(newName);
//                    saverToFiles.saveModels(models);
//                    break;
//                case 3:
//                    System.out.print("Введите новый размер модели: ");
//                    int newSize=getNumber();
//                    models.get(numberModel-1).setSize(newSize);
//                    saverToFiles.saveModels(models);
//                    break;
//                case 4:
//                    System.out.print("Введите новую цену модели: ");
//                    int newPrice=getNumber();
//                    models.get(numberModel-1).setPrice(newPrice);
//                    saverToFiles.saveModels(models);
//                    break;
//                case 5:
//                    System.out.print("Введите новое количество экземпляров: ");
//                    int newQuantity=getNumber();
//                    models.get(numberModel-1).setQuantity(newQuantity);
//                    saverToFiles.saveModels(models);
//                    break;
//            }
//         }while("yes".equals(repeat));
    }
//
    private void changeCustomer() {
//        Set<Integer> changeNumber = new HashSet<>();
//        changeNumber.add(1);
//        changeNumber.add(2);
//        Set<Integer> setNumbersReaders = printListReaders();
//        if(setNumbersReaders.isEmpty()){
//            return;
//        }
//        System.out.println("Выберите номер читателя: ");
//        int numberReader = insertNumber(setNumbersReaders);
//        System.out.println("Имя читателя: "+customers.get(numberReader - 1).getFirstname());
//        System.out.println("Для изменения введите 1, чтобы пропустить нажмите 2");
//        int change = insertNumber(changeNumber);
//        if(1 == change){
//            System.out.println("Введите новое имя читателя: ");
//            customers.get(numberReader - 1).setFirstname(scanner.nextLine());
//        }
//        System.out.println("Фамилия читателя: "+customers.get(numberReader - 1).getLastname());
//        System.out.println("Для изменения введите 1, чтобы пропустить нажмите 2");
//        change = insertNumber(changeNumber);
//        if(1 == change){
//            System.out.println("Введите новую фамилию читателя: ");
//            customers.get(numberReader - 1).setLastname(scanner.nextLine());
//        }
//        System.out.println("Телефон читателя: "+customers.get(numberReader - 1).getPhone());
//        System.out.println("Для изменения введите 1, чтобы пропустить нажмите 2");
//        change = insertNumber(changeNumber);
//        if(1 == change){
//            System.out.println("Введите новый телефон читателя: ");
//            customers.get(numberReader - 1).setPhone(scanner.nextLine());
//        }
    }
}
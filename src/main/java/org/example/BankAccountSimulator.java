package org.example;

import java.util.Scanner;

public class BankAccountSimulator {
    private static final Scanner input = new Scanner(System.in);
    private static int choose=0;
    public void start(){

        do{
            System.out.println("Welcome to the Bank Account Simulator!!!");
            System.out.println("Select the option you want to perform");
            System.out.println("1. View account balance");
            System.out.println("2. Make a deposit ");
            System.out.println("3. Make a withdrawal");
            System.out.println("4. Exit the program");
            choose=input.nextInt();
            switch (choose){
                case 1-> checkBalance();
                case 2-> deposit();
                case 3-> withdraw();
                case 4-> exit();
            }
        }while (choose!=4);
    }
    public void checkBalance(){

    }
    public void deposit(){

    }
    public void withdraw(){

    }
    public void exit(){
        choose=4;
        System.out.println("We appreciate you using our bank account simulator.");
        input.close();
    }
}

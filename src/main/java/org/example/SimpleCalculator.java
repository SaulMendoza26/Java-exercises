package org.example;

import java.util.Scanner;

public class SimpleCalculator {
   private static final  Scanner input = new Scanner(System.in);
         public static void start (){

            int i;
            do {
                System.out.println("Welcome to the simple calculator, choose the operation you want to do: ");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5 Exit");
                i = input.nextInt();
                switch (i){

                    case 1 -> addition();
                    case 2 -> subtraction();
                    case 3 -> multiplication();
                    case 4 -> division();

                    default ->
                        System.out.println("This operation is not allowed, you must choose an option thatr is displayed ob the console");

                }
                System.out.println("El total actual: " +  total);
            }while(i!=5);
            System.out.println("Thank you by use us application");
            input.close();
        }
        private static Double total=0.0;
        private static void addition(){
            if(total==0){
                System.out.println("Enter the first amount:");
                total= input.nextDouble();
            }
            System.out.println("Enter the second amount:");
            double secondAmount = input.nextDouble();
            total +=secondAmount;
        }
        private static void subtraction(){
            if(total==0){
                System.out.println("Enter the first amount:");
                total= input.nextDouble();
            }
            System.out.println("Enter the second amount:");
            double secondAmount = input.nextDouble();
            total -=secondAmount;
        }
        private  static void  multiplication(){
            if(total==0){
                System.out.println("Enter the first amount:");
                total= input.nextDouble();
            }
            System.out.println("Enter the second amount:");
           double secondAmount = input.nextDouble();
            total *=secondAmount;
        }
        private static void division(){
            if(total==0){
                System.out.println("Enter the first amount:");
                total= input.nextDouble();
            }
            System.out.println("Enter the second amount:");
            double secondAmount = input.nextDouble();
            total /=secondAmount;

        }
}

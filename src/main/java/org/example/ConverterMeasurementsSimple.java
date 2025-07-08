package org.example;

import java.util.Scanner;

public class ConverterMeasurementsSimple {
    private static final Scanner input= new Scanner(System.in);
    public static void start (){

        int i;
        do {
            System.out.println("Welcome to the simple calculator, choose the operation you want to do: ");
            System.out.println("1. Meters to feet");
            System.out.println("2. Kilos to pounds");
            System.out.println("3. Pounds to kilo");
            System.out.println("4. Feet to meters");
            System.out.println("5 Exit");
            i = input.nextInt();
            switch (i){

                case 1 -> metersToFeet();
                case 2 -> kilosToPounds();
                case 3 -> poundsToKilos();
                case 4 -> feetToMeters();
                case 5 -> input.close();
                default ->
                        System.out.println("This operation is not allowed, you must choose an option that is displayed ob the console");

            }

        }while(i!=5);
        System.out.println("Thank you by use us application");

    }

    public static void metersToFeet(){
        System.out.println("Enter the numbers of meters to converter to feet");
        double amount = input.nextDouble();
        System.out.println(amount*3.28084);
    }
    public static void kilosToPounds(){
        System.out.println("Enter the numbers of kilos to converter to pounds");
        double amount = input.nextDouble();
        System.out.println(amount*2.20462);
    }
    public static void feetToMeters(){
        System.out.println("Enter the numbers of feet to converter to meters");
        double amount = input.nextDouble();
        System.out.println(amount/3.28084);
    }
    public static void poundsToKilos(){
        System.out.println("Enter the numbers of pounds to converter to kilos");
        double amount = input.nextDouble();
        System.out.println(amount/2.20462);
    }

}

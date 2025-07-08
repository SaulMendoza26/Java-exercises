package org.example;

import java.util.Scanner;

public class GuessTheNumber {
    private static final Scanner input = new Scanner(System.in);
        public static void start(){
            try{
                System.out.println("Welcome! Let's play 'Find the Number'.");
                System.out.println("Enter a number between 1 and 100");
                int myNumber= input.nextInt();
                int findNumber = (int) (Math.random()*100);
                boolean condition=true;
                int counter =0;
                while(condition){
                    counter++;
                    if(myNumber==findNumber){
                        System.out.println("Excellent! You've found the number!!!");
                        condition=false;
                    }else if(myNumber<findNumber){
                        System.out.println("Your guess is too low. Try a higher number!");
                        myNumber= input.nextInt();
                    }else{
                        System.out.println("Your guess is too high. Try a lower number!");
                        myNumber= input.nextInt();
                    }
                }

                System.out.println("The number was: "+findNumber+ " and your attempts were: " + counter);
            }catch (Exception e){
             e.printStackTrace();
            }finally {
                input.close();
            }

        }
}

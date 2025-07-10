package org.example;

import org.example.crud.model.ConnectionDataBase;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //SimpleCalculator.start();
        //ConverterMeasurementsSimple.start();
        //GuessTheNumber.start();
        //BankAccountSimulator.start();
        //Store.start();
        System.out.println(ConnectionDataBase.getConnection());
    }
}
package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Store {


    public static void start() {
        List<Product> products= new ArrayList<>();
        products.add(new Product(1L,"Laptop",899.99,10));
        products.add(new Product(2L,"Mouse", 19.99, 100));
        products.add(new Product(3L,"Monitor", 199.99, 30));
        products.add(new Product(4L,"Teclado", 49.99, 60));
        products.sort(Comparator.comparingDouble((Product::getPrices)));
        System.out.printf("%-15s %-10s %-10s%n", "Name" , "Price", "Stock");
        System.out.println("---------------------------------------------");
        for (Product p : products){
            System.out.printf("%-15s $%-9.2f %-10d%n", p.getName(),p.getPrices(),p.getStock());
        }
    }


}
class Product{
    private Long id;
    private String name;
    private double prices;
    private int stock;

    public Product(Long id, String name,double prices, int stock){
        this.id = id;
        this.name = name;
        this.prices = prices;
        this.stock= stock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrices() {
        return prices;
    }

    public int getStock() {
        return stock;
    }
}
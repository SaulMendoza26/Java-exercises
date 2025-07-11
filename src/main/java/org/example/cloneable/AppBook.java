package org.example.cloneable;

import java.util.ArrayList;

public class AppBook {

    public static void main(String[] args) {
        try{
            //Depp copying using clone method
            Book book1 = new Book("1984", "George Orwell", null);
            Book book2 = book1.clone(); // Cloning the book1 object
            book2.setTitle("Animal Farm"); // Changing the title of the cloned book
            Chapter chapter1 = new Chapter("Chapter 1", "Content of Chapter 1");
            Chapter chapter2 = new Chapter("Chapter 2", "Content of Chapter 2");
            ArrayList<Chapter> chapters = new ArrayList<>();
            chapters.add(chapter1);
            chapters.add(chapter2);
            book2.setChapters(chapters); // Adding chapters to the cloned book
            System.out.println("Original Book Title: " + book1.getTitle() + ", Author: " + book1.getAuthor()+
                    " Chapters: " + book1.getChapters().size());
            System.out.println("Cloned Book Title: " + book2.getTitle() + ", Author: " + book2.getAuthor() +
                    " Chapters: " + book2.getChapters().size());
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}

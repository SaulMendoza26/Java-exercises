package org.example.cloneable;

import java.util.ArrayList;
import java.util.List;

public class Book implements  Cloneable {
private String  title;
private String author;
private List<Chapter> chapters;


public Book(String title, String author , List<Chapter> chapters) {
    this.title=title;
    this.author=author;
    this.chapters = chapters != null ? new ArrayList<>(chapters) : new ArrayList<>();
}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public Book clone() throws CloneNotSupportedException {
    Book book= (Book) super.clone();
    // If chapters is mutable and needs deep cloning, you would need to clone each chapter as well.
        book.chapters =new ArrayList<>(this.chapters);
        return book;

}
}

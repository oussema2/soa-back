package org.example.Entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Catgorie {

    private int id ;
    private String label ;

    private int booksNumber;

    public Catgorie(int id, String label , int bookNum) {
        this.id = id;
        this.label = label;
        this.booksNumber = bookNum;
    }
    public Catgorie() {

    }

    public int getBooksNumber() {
        return booksNumber;
    }

    public void setBooksNumber(int booksNumber) {
        this.booksNumber = booksNumber;
    }

    @Override
    public String toString() {
        return "Catgorie{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", booksNumber=" + booksNumber +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

package org.example.Entity;

public class LivreWithCatLabel {
    private int id ;
    private String title;
    private String author;
    private int pageNumber;
    private float price;
    private int idCat;
    private String catLabel;

    public LivreWithCatLabel(int id, String title, String author, int pageNumber, float price, int idCat, String catLabel) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pageNumber = pageNumber;
        this.price = price;
        this.idCat = idCat;
        this.catLabel = catLabel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getCatLabel() {
        return catLabel;
    }

    public void setCatLabel(String catLabel) {
        this.catLabel = catLabel;
    }
}

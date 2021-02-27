package com.example.bibliotekaaa.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class Kniga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    private String year;
    private String pages;
    private String image;
    public Kniga(){

    }

    public Kniga(String name, String price, String year, String pages, String image) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.year = year;
        this.pages = pages;
        this.image = image;
        this.price=price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getHorsepower() {
        return pages;
    }

    public void setHorsepower(String horsepower) {
        this.pages = horsepower;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

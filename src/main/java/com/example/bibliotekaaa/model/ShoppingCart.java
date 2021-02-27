package com.example.bibliotekaaa.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDateTime dateCreated;

    @ManyToOne
    private Korisnik korisnik;

    @ManyToMany
    private List<Kniga> products;

    @Enumerated(value = EnumType.STRING)
    private ShoppingCartStatus status;

    public ShoppingCart() {
        this.id = (long) (Math.random() * 1000);
    }

    public ShoppingCart(Korisnik korisnik) {
        this.id = (long) (Math.random() * 1000);
        this.dateCreated = LocalDateTime.now();
        this.korisnik = korisnik;
        this.products = new ArrayList<>();
        this.status = ShoppingCartStatus.CREATED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public List<Kniga> getProducts() {
        return products;
    }

    public void setProducts(List<Kniga> products) {
        this.products = products;
    }

    public ShoppingCartStatus getStatus() {
        return status;
    }

    public void setStatus(ShoppingCartStatus status) {
        this.status = status;
    }
}

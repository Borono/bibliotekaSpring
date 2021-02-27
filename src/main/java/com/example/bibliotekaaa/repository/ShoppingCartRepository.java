package com.example.bibliotekaaa.repository;

import com.example.bibliotekaaa.bootstrap.DataHolder;
import com.example.bibliotekaaa.model.ShoppingCart;
import com.example.bibliotekaaa.model.ShoppingCartStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ShoppingCartRepository {
    public Optional<ShoppingCart> findById(Long id) {
        return DataHolder.shoppingCarts.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public Optional<ShoppingCart> findByUsernameAndStatus(String username, ShoppingCartStatus status) {
        return DataHolder.shoppingCarts.stream()
                .filter(i -> i.getKorisnik().getUsername().equals(username) && i.getStatus().equals(status))
                .findFirst();
    }


    public ShoppingCart save(ShoppingCart shoppingCart) {
        DataHolder.shoppingCarts
                .removeIf(i -> i.getKorisnik().getUsername().equals(shoppingCart.getKorisnik().getUsername()));

        DataHolder.shoppingCarts.add(shoppingCart);
        return shoppingCart;
    }

}

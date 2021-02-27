package com.example.bibliotekaaa.service;

import com.example.bibliotekaaa.model.Kniga;
import com.example.bibliotekaaa.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<Kniga> listAllProducts(Long cartId);
    ShoppingCart getActiveShoppingCart(String username);
    ShoppingCart addProductToShoppingCart(String username, Long productId);


}
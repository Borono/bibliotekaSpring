package com.example.bibliotekaaa.repository.jpa;

import com.example.bibliotekaaa.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {

}

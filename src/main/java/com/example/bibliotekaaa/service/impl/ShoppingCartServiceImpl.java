package com.example.bibliotekaaa.service.impl;

import com.example.bibliotekaaa.model.Kniga;
import com.example.bibliotekaaa.model.Korisnik;
import com.example.bibliotekaaa.model.ShoppingCart;
import com.example.bibliotekaaa.model.ShoppingCartStatus;
import com.example.bibliotekaaa.repository.KorisnikRepository;
import com.example.bibliotekaaa.repository.ShoppingCartRepository;
import com.example.bibliotekaaa.service.KnigaService;
import com.example.bibliotekaaa.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final KnigaService knigaService;
    private final KorisnikRepository korisnikRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, KnigaService knigaService, KorisnikRepository korisnikRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.knigaService = knigaService;
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public List<Kniga> listAllProducts(Long cartId) {
        return this.shoppingCartRepository.findById(cartId).get().getProducts();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        return this.shoppingCartRepository
                .findByUsernameAndStatus(username, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    Korisnik korisnik = this.korisnikRepository.findByUsername(username)
                            .orElseThrow();
                    ShoppingCart shoppingCart = new ShoppingCart(korisnik);
                    return this.shoppingCartRepository.save(shoppingCart);
                });

    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Long carId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Kniga kniga = this.knigaService.findById(carId)
                .orElseThrow();

        shoppingCart.getProducts().add(kniga);
        return this.shoppingCartRepository.save(shoppingCart);

    }
}


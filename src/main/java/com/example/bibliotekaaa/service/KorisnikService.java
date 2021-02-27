package com.example.bibliotekaaa.service;

import com.example.bibliotekaaa.model.Korisnik;

public interface KorisnikService {

    Korisnik login(String username, String password);
    Korisnik register(String username, String password, String repeatPassword, String name, String surname);
}

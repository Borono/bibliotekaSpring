package com.example.bibliotekaaa.service.impl;

import com.example.bibliotekaaa.model.Korisnik;
import com.example.bibliotekaaa.model.exceptions.InvalidArgumentException;
import com.example.bibliotekaaa.repository.KorisnikRepository;
import com.example.bibliotekaaa.service.KorisnikService;
import org.springframework.stereotype.Service;

@Service
public class KorisnikServiceImpl implements KorisnikService {
    private final KorisnikRepository korisnikRepository;

    public KorisnikServiceImpl(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public Korisnik login(String username, String password) {

        return korisnikRepository.findByUsernameAndPassword(username,
                password).orElseThrow();

    }

    @Override
    public Korisnik register(String username, String password, String repeatPassword, String name, String surname) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty()) {
            throw new InvalidArgumentException();
        }

        Korisnik korisnik = new Korisnik(username,password,name,surname);
        return korisnikRepository.saveOrUpdate(korisnik);

    }
}
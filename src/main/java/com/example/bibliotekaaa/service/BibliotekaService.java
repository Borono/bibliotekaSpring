package com.example.bibliotekaaa.service;

import com.example.bibliotekaaa.model.Biblioteka;

import java.util.List;
import java.util.Optional;

public interface BibliotekaService {
    List<Biblioteka> listAll();
    Optional<Biblioteka> findById(Long id);
    Optional<Biblioteka> save( String name, String grad, String lokacija, String kapacitet);
    void deleteById(Long id);
}

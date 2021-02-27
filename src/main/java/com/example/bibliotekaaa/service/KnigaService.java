package com.example.bibliotekaaa.service;

import com.example.bibliotekaaa.model.Kniga;

import java.util.List;
import java.util.Optional;

public interface KnigaService {
    List<Kniga> listAll();
    Optional<Kniga> findById(Long id);
    Optional<Kniga> save( String name, String price, String year, String horsepower, String image);
    void deleteById(Long id);
}
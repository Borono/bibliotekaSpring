package com.example.bibliotekaaa.repository;

import com.example.bibliotekaaa.bootstrap.DataHolder;
import com.example.bibliotekaaa.model.Biblioteka;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BibliotekaRepository {
    public List<Biblioteka> listAll(){
        return DataHolder.libraryList;
    }
    public Optional<Biblioteka> findById(Long id) {
        return DataHolder.libraryList.stream().filter(i -> i.getId().equals(id)).findFirst();
    }



    public void deleteById(Long id) {
        DataHolder.libraryList.removeIf(i -> i.getId().equals(id));
    }

    public Optional<Biblioteka> save( String name, String grad, String lokacija, String kapacitet
    ) {
        DataHolder.libraryList.removeIf(i -> i.getName().equals(name));
        Biblioteka biblioteka = new Biblioteka(name, grad, lokacija, kapacitet);
        DataHolder.libraryList.add(biblioteka);
        return Optional.of(biblioteka);
    }
}

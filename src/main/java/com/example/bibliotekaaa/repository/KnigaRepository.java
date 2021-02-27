package com.example.bibliotekaaa.repository;

import com.example.bibliotekaaa.bootstrap.DataHolder;
import com.example.bibliotekaaa.model.Kniga;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class KnigaRepository {
    public List<Kniga> listAll(){
        return DataHolder.booksList;
    }
    public Optional<Kniga> findById(Long id) {
        return DataHolder.booksList.stream().filter(i -> i.getId().equals(id)).findFirst();
    }



    public void deleteById(Long id) {
        DataHolder.booksList.removeIf(i -> i.getId().equals(id));
    }

    public Optional<Kniga> save( String name, String price, String year, String pages, String image
    ) {
        DataHolder.booksList.removeIf(i -> i.getName().equals(name));
        Kniga kniga = new Kniga(name, price, year, pages, image);
        DataHolder.booksList.add(kniga);
        return Optional.of(kniga);
    }
}

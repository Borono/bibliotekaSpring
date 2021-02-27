package com.example.bibliotekaaa.service.impl;

import com.example.bibliotekaaa.model.Kniga;
import com.example.bibliotekaaa.repository.KnigaRepository;
import com.example.bibliotekaaa.repository.jpa.JpaKnigaRepository;
import com.example.bibliotekaaa.service.KnigaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KnigaServiceImpl implements KnigaService {
    private final JpaKnigaRepository knigaRepository;

    public KnigaServiceImpl(JpaKnigaRepository knigaRepository) {
        this.knigaRepository = knigaRepository;
    }

    @Override
    public List<Kniga> listAll() {
        return this.knigaRepository.findAll();
    }

    @Override
    public Optional<Kniga> findById(Long id) {
        return this.knigaRepository.findById(id);
    }

    @Override
    public Optional<Kniga> save(String name, String price, String year, String horsepower, String image) {
        return Optional.of(this.knigaRepository.save(new Kniga(name, price, year, horsepower, image)));
    }

    @Override
    public void deleteById(Long id) {
        this.knigaRepository.deleteById(id);
    }

}

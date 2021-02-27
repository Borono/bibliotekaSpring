package com.example.bibliotekaaa.service.impl;

import com.example.bibliotekaaa.model.Biblioteka;
import com.example.bibliotekaaa.repository.BibliotekaRepository;
import com.example.bibliotekaaa.repository.jpa.JpaBibliotekaRepository;
import com.example.bibliotekaaa.service.BibliotekaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotekaServiceImpl implements BibliotekaService {
    private final JpaBibliotekaRepository bibliotekaRepository;

    public BibliotekaServiceImpl(JpaBibliotekaRepository bibliotekaRepository) {
        this.bibliotekaRepository = bibliotekaRepository;
    }

    @Override
    public List<Biblioteka> listAll() {
        return this.bibliotekaRepository.findAll();
    }

    @Override
    public Optional<Biblioteka> findById(Long id) {
        return this.bibliotekaRepository.findById(id);
    }

    @Override
    public Optional<Biblioteka> save(String name, String grad, String lokacija, String kapacitet) {
        return Optional.of(this.bibliotekaRepository.save(new Biblioteka(name, grad, lokacija, kapacitet)));
    }

    @Override
    public void deleteById(Long id) {
        this.bibliotekaRepository.deleteById(id);
    }
}

package com.example.bibliotekaaa.service;

import com.example.bibliotekaaa.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> listAll();
    Optional<User> findById(Long id);
    Optional<User> save( String name, String surname, String email);
    void deleteById(Long id);

}
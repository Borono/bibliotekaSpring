package com.example.bibliotekaaa.service.impl;

import com.example.bibliotekaaa.model.User;
import com.example.bibliotekaaa.model.exceptions.InvalidArgumentException;
import com.example.bibliotekaaa.repository.UserRepository;
import com.example.bibliotekaaa.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> listAll() {
        return this.userRepository.listAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public Optional<User> save( String name,String surname, String email) {
        if (
                name== null || name.isEmpty() ||
                        surname== null || surname.isEmpty() ){
            throw new InvalidArgumentException();
        }
        return this.userRepository.save( name, surname, email);
    }



    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }
}

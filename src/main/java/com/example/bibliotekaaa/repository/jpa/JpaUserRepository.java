package com.example.bibliotekaaa.repository.jpa;

import com.example.bibliotekaaa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<User,Long> {

}

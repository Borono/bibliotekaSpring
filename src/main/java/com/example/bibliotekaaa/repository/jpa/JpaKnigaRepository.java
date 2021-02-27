package com.example.bibliotekaaa.repository.jpa;

import com.example.bibliotekaaa.model.Kniga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaKnigaRepository extends JpaRepository<Kniga,Long> {

}

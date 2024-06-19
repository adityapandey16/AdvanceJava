package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Recepie;

public interface RecepieRepository extends JpaRepository<Recepie, Long> {

}

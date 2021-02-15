package com.qintess.arcadenoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.arcadenoe.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}

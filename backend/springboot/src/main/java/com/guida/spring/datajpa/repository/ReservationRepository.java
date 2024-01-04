package com.guida.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guida.spring.datajpa.model.Reservations;

public interface ReservationRepository extends JpaRepository<Reservations, Long>{

    

    
}

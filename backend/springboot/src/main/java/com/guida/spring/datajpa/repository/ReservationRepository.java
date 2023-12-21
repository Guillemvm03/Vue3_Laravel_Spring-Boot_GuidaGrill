package com.guida.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.guida.spring.datajpa.model.Reservations;

public interface ReservationRepository extends JpaRepository<Reservations, Long> {


    
}

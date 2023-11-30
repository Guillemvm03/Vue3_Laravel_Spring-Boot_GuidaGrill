package com.guida.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guida.spring.datajpa.model.Meals;

public interface MealsRepository extends JpaRepository<Meals, Long> {

    
} 

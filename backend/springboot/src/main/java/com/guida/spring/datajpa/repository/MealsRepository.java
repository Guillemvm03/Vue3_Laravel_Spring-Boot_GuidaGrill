package com.guida.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.guida.spring.datajpa.model.Meals;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MealsRepository extends JpaRepository<Meals, Long> {

@Query(value = "SELECT * FROM meals WHERE meals.id_menu = :id_menu LIMIT :limit", nativeQuery = true)
List<Meals> findMeals(@Param("limit") Integer limit, @Param("id_menu") Integer id_menu);


} 

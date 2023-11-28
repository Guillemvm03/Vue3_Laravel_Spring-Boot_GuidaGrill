package com.guida.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guida.spring.datajpa.model.Menu;

// public class MenuRepository {
    
// }

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
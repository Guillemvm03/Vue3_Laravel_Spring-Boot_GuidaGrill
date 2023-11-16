package com.guida.spring.datajpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.guida.spring.datajpa.model.Tables;

public interface TableRepository extends JpaRepository<Tables, Long> {
}

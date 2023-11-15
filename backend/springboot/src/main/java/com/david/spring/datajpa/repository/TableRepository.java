package com.david.spring.datajpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.david.spring.datajpa.model.Tables;

public interface TableRepository extends JpaRepository<Tables, Long> {
}

package com.david.spring.datajpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.david.spring.datajpa.model.Mesas;

public interface MesasRepository extends JpaRepository<Mesas, Long> {
}

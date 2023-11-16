package com.guida.spring.datajpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.guida.spring.datajpa.model.Mesas;

public interface MesasRepository extends JpaRepository<Mesas, Long> {
}

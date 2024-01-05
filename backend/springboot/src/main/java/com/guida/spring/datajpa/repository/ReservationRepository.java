package com.guida.spring.datajpa.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.guida.spring.datajpa.model.Reservations;

public interface ReservationRepository extends JpaRepository<Reservations, Long>{

    
    @Query(value = "SELECT * FROM reservations r WHERE r.table_id = :id", nativeQuery = true)
    List<Reservations> findByTableId(@Param("id") Long id);

    @Query(value = "SELECT r.* FROM reservations r WHERE r.user_id = :id ", nativeQuery = true)
    List<Reservations> findByUserId(@Param("id") Long id);
    
}
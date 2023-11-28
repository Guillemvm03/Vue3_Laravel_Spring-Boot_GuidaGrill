package com.guida.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.guida.spring.datajpa.model.Tables;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TableRepository extends JpaRepository<Tables, Long> {

//QUERY GET ALL MENUS

// @Query(value = "SELECT t.* FROM tables t " +
//                "JOIN tables_menu tm ON t.id = tm.tables_id " +
//                "JOIN menu m ON m.id = tm.menus_id " +
//                "WHERE m.id IN (:menu) AND t.table_number = :table.number ", nativeQuery = true)

// List<Tables> findMenusOnTable(@Param("menu") String[] menu, @Param("table_number") Integer table_number);


@Query(value = "SELECT t.* FROM tables t " +
               "JOIN tables_menu tm ON t.id = tm.tables_id " +
               "JOIN menu m ON m.id = tm.menus_id " +
               "WHERE m.id IN (:menu) ", nativeQuery = true)


List<Tables> findMenusOnTable(@Param("menu") String[] menu);


//QUERY GET AVAILABLE




// List<Tables> findMenusOnTable(@Param("menus") String[] menus, @Param("table_number")String table_number);


}

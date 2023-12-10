package com.guida.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.guida.spring.datajpa.model.Tables;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TableRepository extends JpaRepository<Tables, Long> {

//QUERY GET ALL MENUS
@Query(value = "SELECT t.* FROM tables t " +
               "JOIN tables_menu tm ON t.id = tm.tables_id " +
               "JOIN menu m ON m.id = tm.menus_id " +
               "WHERE m.id IN (:menu) AND t.available LIKE true", nativeQuery = true)


List<Tables> findMenusOnTable(@Param("menu") String[] menu);

//QUERY GET ALL CATEGORIES
@Query(value = "SELECT * FROM tables WHERE category LIKE :category AND available LIKE true", nativeQuery = true)

List<Tables> findCategoriesOnTable(@Param("category") String category);

//QUERY GET TABLES FROM CATEGORY AND MENU
@Query(value = "SELECT t.* FROM tables t " +
               "JOIN tables_menu tm ON t.id = tm.tables_id " +
               "JOIN menu m ON m.id = tm.menus_id " +
               "WHERE m.id IN (:menu) AND t.category LIKE :category AND t.available LIKE true", nativeQuery = true)

List<Tables> findTablesByMenuAndCategory(@Param("menu") String[] menu, @Param("category") String category);

//QUERY GET ALL AVAILABLE OR NOT AVAILABLE TABLES

// @Query(value = "SELECT * FROM tables WHERE available = :available", nativeQuery = true)

// List<Tables> findByAvailable(@Param("available") boolean available);

//QUERY GET ALL TABLES BY TYPE AVAILABLE OR NOT AVAILABLE

// @Query(value = "SELECT * FROM tables WHERE category = :category and available = :available", nativeQuery = true)

// List<Tables> findByType(@Param("category") String category, @Param("available") boolean available);

//QUERY GET MENU ON TABLE AVAILABLE OR NOT AVAILABLE NOT CATEGORY

// @Query(value = "SELECT t.* FROM tables t " + 
//                "JOIN tables_menu tm ON t.id = tm.tables_id JOIN menu m ON m.id = tm.menus_id " +
//                "WHERE m.id IN (:menu) AND t.available = :available", nativeQuery = true)
// List<Tables> findTablesByMenuAndAvailability(@Param("menu") String[] menu, @Param("available") boolean available);

// //QUERY GET MENU ON TABLE AVAILABLE OR NOT AVAILABLE WITH CATEGORY

// @Query(value = "SELECT t.* FROM tables t " + 
//                "JOIN tables_menu tm ON t.id = tm.tables_id JOIN menu m ON m.id = tm.menus_id " +
//                "WHERE m.id IN (:menu) AND t.available = :available AND t.category = :category", nativeQuery = true)
// List<Tables> findTablesByMenuAndAvailabilityAndCategory(@Param("menu") String[] menu, @Param("available") boolean available, @Param("category") String category);



//QUERY GET ALL NOT AVAILABLE TABLES

// @Query(value = "SELECT * FROM tables WHERE available = false", nativeQuery = true)

// List<Tables> findByNotAvailable(@Param("available") boolean available);


// List<Tables> findMenusOnTable(@Param("menus") String[] menus, @Param("table_number")String table_number);


}

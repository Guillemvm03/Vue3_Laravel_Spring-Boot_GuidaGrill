package com.guida.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.guida.spring.datajpa.model.Tables;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TableRepository extends JpaRepository<Tables, Long> {


// FIND ALL

@Query(value ="SELECT * FROM tables LIMIT :limit OFFSET :offset",nativeQuery = true)

List<Tables> findAllTables(@Param("limit") Integer limit, @Param("offset") Integer offset);

//QUERY GET ALL MENUS
@Query(value = "SELECT t.* FROM tables t " +
               "JOIN tables_menu tm ON t.id = tm.tables_id " +
               "JOIN menu m ON m.id = tm.menus_id " +
               "WHERE m.id IN (:menu) AND t.available LIKE true LIMIT :limit OFFSET :offset", nativeQuery = true)


List<Tables> findMenusOnTable(@Param("menu") String[] menu, @Param("limit") Integer limit, @Param("offset") Integer offset);

//QUERY GET ALL CATEGORIES
@Query(value = "SELECT * FROM tables WHERE category LIKE :category AND available LIKE true LIMIT :limit OFFSET :offset", nativeQuery = true)

List<Tables> findCategoriesOnTable(@Param("category") String category, @Param("limit") Integer limit, @Param("offset") Integer offset);

//QUERY GET TABLES FROM CATEGORY AND MENU
@Query(value = "SELECT t.* FROM tables t " +
               "JOIN tables_menu tm ON t.id = tm.tables_id " +
               "JOIN menu m ON m.id = tm.menus_id " +
               "WHERE m.id IN (:menu) AND t.category LIKE :category AND t.available LIKE true", nativeQuery = true)

List<Tables> findTablesByMenuAndCategory(@Param("menu") String[] menu, @Param("category") String category);





//PAGINATE

//MENU PAG
@Query(value = "SELECT COUNT(*) FROM tables t " +
               "JOIN tables_menu tm ON t.id = tm.tables_id " +
               "JOIN menu m ON m.id = tm.menus_id " +
               "WHERE m.id IN (:menu) AND t.available LIKE true", nativeQuery = true)


Integer findMenusOnTableAndPaginate(@Param("menu") String[] menu);

//ALL PAG

@Query(value = "SELECT COUNT(*) FROM tables", nativeQuery = true)

Integer findTablesPaginate();

// CATEGORY

@Query(value = "SELECT COUNT(*) FROM tables WHERE category LIKE :category AND available LIKE true", nativeQuery = true)

Integer findCategoryPaginate(@Param("category") String category);




}

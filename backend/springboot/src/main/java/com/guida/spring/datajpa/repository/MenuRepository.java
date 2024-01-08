package com.guida.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.guida.spring.datajpa.model.Meals;
import com.guida.spring.datajpa.model.Menu;

// public class MenuRepository {
    
// }

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query(value = "SELECT * FROM meals me WHERE me.id_menu = :type LIMIT :limit", nativeQuery = true)
List<Menu> findMenusInfinite(@Param("limit") Integer limit, @Param("type") String type);
}
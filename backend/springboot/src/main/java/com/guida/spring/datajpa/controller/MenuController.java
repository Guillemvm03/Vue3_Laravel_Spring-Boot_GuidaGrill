package com.guida.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guida.spring.datajpa.model.Menu;
import com.guida.spring.datajpa.repository.MenuRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MenuController {

	@Autowired
	MenuRepository menurepository;

	@GetMapping("/menus")
	public ResponseEntity<List<Menu>> getAllMenus(@RequestParam(required = false) String title) {
		try {
			List<Menu> menu = new ArrayList<Menu>();
		
			menurepository.findAll().forEach(menu::add);			

			return new ResponseEntity<>(menu, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/menus/{id}")
	public ResponseEntity<Menu> getMenuById(@PathVariable("id") long id) {
		Optional<Menu> MenuData = menurepository.findById(id);

		if (MenuData.isPresent()) {
			return new ResponseEntity<>(MenuData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    }
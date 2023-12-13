package com.guida.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guida.spring.datajpa.model.Meals;
import com.guida.spring.datajpa.repository.MealsRepository;
import com.guida.spring.datajpa.model.MealsQueryParam;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MealsController {
    @Autowired
    MealsRepository mealsRepository;

    @GetMapping("/meals")
    public ResponseEntity<List<Meals>> getAllMeals(@ModelAttribute Meals meals) {
        try {
			List<Meals> meal = new ArrayList<Meals>();
		
			mealsRepository.findAll().forEach(meal::add);
			return new ResponseEntity<>(meal, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    @GetMapping("/meals/{id}")
	public ResponseEntity<Meals> getMealsById(@PathVariable("id") long id) {
		Optional<Meals> MealsData = mealsRepository.findById(id);

		if (MealsData.isPresent()) {
			return new ResponseEntity<>(MealsData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/meals/mealsInfinite")
	public ResponseEntity<List<Meals>> getMealsInfinite(@ModelAttribute MealsQueryParam mealsQueryParam) {
		try {
			// System.out.println(mealsQueryParam.getPage() * mealsQueryParam.getLimit());
			List<Meals> meal = new ArrayList<Meals>();
			Integer limit = mealsQueryParam.getPage() * mealsQueryParam.getLimit();  
			mealsRepository.findMeals(limit, mealsQueryParam.getId_menu()).forEach(meal::add);
			// System.out.println(meal);
			return new ResponseEntity<>(meal, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
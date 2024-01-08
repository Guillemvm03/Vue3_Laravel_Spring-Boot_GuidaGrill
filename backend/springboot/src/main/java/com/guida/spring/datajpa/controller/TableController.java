package com.guida.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guida.spring.datajpa.model.Tables;
import com.guida.spring.datajpa.repository.TableRepository;
import com.guida.spring.datajpa.model.TableQueryParam;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TableController {

	@Autowired
	TableRepository tableRepository;

	@GetMapping("/tables")
	public ResponseEntity<List<Tables>> getAllTable(@ModelAttribute TableQueryParam tableQueryParam) {
		try {

			Integer offset = (tableQueryParam.getPage() - 1) * tableQueryParam.getLimit();

			List<Tables> table = new ArrayList<Tables>();

			// Get all tables from menu			
			if (tableQueryParam.getMenu() != null 
				&& tableQueryParam.getCategory() == "" || tableQueryParam.getCategory() == null
				&& tableQueryParam.all() == false    
				) {

				table = tableRepository.findMenusOnTable(tableQueryParam.getMenu(),tableQueryParam.getLimit(), offset);
			}
			//get all tables from category
			else if(tableQueryParam.getMenu() == null 
					&& tableQueryParam.getCategory() != "" 
					&& tableQueryParam.all() == false
					){

				table = tableRepository.findCategoriesOnTable(tableQueryParam.getCategory(),tableQueryParam.getLimit(), offset);
			}
			//get all tables from category and menu
			else if(tableQueryParam.getMenu() != null 
					&& tableQueryParam.getCategory() != null
					&& tableQueryParam.all() == false
					){

				table = tableRepository.findTablesByMenuAndCategory(tableQueryParam.getMenu(), tableQueryParam.getCategory());
			}					
			//Get all tables
			else {		
				table = tableRepository.findAllTables(tableQueryParam.getLimit(),offset);
			}

			return new ResponseEntity<>(table, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tables/{id}")
	public ResponseEntity<Tables> getTableById(@PathVariable("id") long id) {
		Optional<Tables> tableData = tableRepository.findById(id);

		if (tableData.isPresent()) {
			return new ResponseEntity<>(tableData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/tables/paginate")
	public ResponseEntity<Integer> getTablePaginate(@ModelAttribute TableQueryParam tableQueryParam) {
		try {
			Integer total = 0;

			if (tableQueryParam.getMenu() != null && (tableQueryParam.getCategory() == null || tableQueryParam.getCategory().isEmpty())
					|| tableQueryParam.getCategory() == null && !tableQueryParam.all()) {
				
				total = tableRepository.findMenusOnTableAndPaginate(tableQueryParam.getMenu());
			}else if(
			tableQueryParam.getMenu() == null 
					&& tableQueryParam.getCategory() != "" 
					&& tableQueryParam.all() == false
				){
				total = tableRepository.findCategoryPaginate(tableQueryParam.getCategory());
			} else {
				total = tableRepository.findTablesPaginate();
			}
	
			return new ResponseEntity<>(total, HttpStatus.OK);
	
		} catch (Exception e) {
			System.err.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}

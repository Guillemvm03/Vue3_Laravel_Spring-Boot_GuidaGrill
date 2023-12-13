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

				System.out.println("menu");
				table = tableRepository.findMenusOnTable(tableQueryParam.getMenu(),tableQueryParam.getLimit(), offset);
			}
			//get all tables from category
			else if(tableQueryParam.getMenu() == null 
					&& tableQueryParam.getCategory() != "" 
					&& tableQueryParam.all() == false
					){

				System.out.println("category");

				table = tableRepository.findCategoriesOnTable(tableQueryParam.getCategory(),tableQueryParam.getLimit(), offset);
			}
			//get all tables from category and menu
			else if(tableQueryParam.getMenu() != null 
					&& tableQueryParam.getCategory() != null
					&& tableQueryParam.all() == false
					){

				System.out.println("category and menu");

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

			// System.out.println("limit" + tableQueryParam.getLimit());
			// System.out.println("page" + tableQueryParam.getPage());

			if (tableQueryParam.getMenu() != null && (tableQueryParam.getCategory() == null || tableQueryParam.getCategory().isEmpty())
					|| tableQueryParam.getCategory() == null && !tableQueryParam.all()) {
				
				total = tableRepository.findMenusOnTableAndPaginate(tableQueryParam.getMenu());
				// System.out.println(total);
			}else if(
			tableQueryParam.getMenu() == null 
					&& tableQueryParam.getCategory() != "" 
					&& tableQueryParam.all() == false
				){
				total = tableRepository.findCategoryPaginate(tableQueryParam.getCategory());
			} else {
				// System.out.println("all pag");
				total = tableRepository.findTablesPaginate();
				// System.out.println(total);
			}
	
			return new ResponseEntity<>(total, HttpStatus.OK);
	
		} catch (Exception e) {
			System.err.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// @GetMapping("/tablesInfinite")
	// public ResponseEntity<List<Tables>> getTableInfinite(@ModelAttribute TableQueryParam tableQueryParam) {
	// 	try{
	// 		List<Tables> table= newArrayList<Tables>();
	// 		Integer limi tableQueryParam.getPage() * tableQueryParam.getLimit();
	// 		tableRepository.findAll().forEach(table::add);
	// 	}
	// 	catch(Exception e){
	// 		System.err.println(e);
	// 		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	// 	}
	// }

	// @PostMapping("/mesas")
	// public ResponseEntity<Mesas> createTutorial(@RequestBody Mesas mesas) {
	// try {
	// Mesas _mesas = mesasRepository
	// .save(new Mesas(mesas.getTitle(), mesas.getDescription(), false));
	// return new ResponseEntity<>(_mesas, HttpStatus.CREATED);
	// } catch (Exception e) {
	// return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	// }
	// }

	// @PutMapping("/mesas/{id}")
	// public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id,
	// @RequestBody Tutorial tutorial) {
	// Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

	// if (tutorialData.isPresent()) {
	// Tutorial _tutorial = tutorialData.get();
	// _tutorial.setTitle(tutorial.getTitle());
	// _tutorial.setDescription(tutorial.getDescription());
	// _tutorial.setPublished(tutorial.isPublished());
	// return new ResponseEntity<>(tutorialRepository.save(_tutorial),
	// HttpStatus.OK);
	// } else {
	// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// }
	// }

	// @DeleteMapping("/mesas/{id}")
	// public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id)
	// {
	// try {
	// tutorialRepository.deleteById(id);
	// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	// } catch (Exception e) {
	// return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	// }
	// }

	// @DeleteMapping("/mesas")
	// public ResponseEntity<HttpStatus> deleteAllMesas() {
	// try {
	// tutorialRepository.deleteAll();
	// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	// } catch (Exception e) {
	// return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	// }

	// }

	// @GetMapping("/tutorials/published")
	// public ResponseEntity<List<Tutorial>> findByPublished() {
	// try {
	// List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

	// if (tutorials.isEmpty()) {
	// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	// }
	// return new ResponseEntity<>(tutorials, HttpStatus.OK);
	// } catch (Exception e) {
	// return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	// }
	// }

}

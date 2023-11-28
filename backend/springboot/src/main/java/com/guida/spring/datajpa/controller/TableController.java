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
			List<Tables> table = new ArrayList<Tables>();
			
			if (tableQueryParam.getMenu() != null && tableQueryParam.getMenu().length != 0) {

				System.out.println("Params" + tableQueryParam.getMenu());

				// table = tableRepository.findMenusOnTable(tableQueryParam.getMenu(),tableQueryParam.getTable_number());
				table = tableRepository.findMenusOnTable(tableQueryParam.getMenu());

			}
			else{
				System.out.println("All");
				tableRepository.findAll().forEach(table::add);
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

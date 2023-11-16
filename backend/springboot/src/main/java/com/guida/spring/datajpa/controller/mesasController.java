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

import com.guida.spring.datajpa.model.Mesas;
import com.guida.spring.datajpa.repository.MesasRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class mesasController {

	@Autowired
	MesasRepository mesasRepository;

	@GetMapping("/mesas")
	public ResponseEntity<List<Mesas>> getAllMesas(@RequestParam(required = false) String title) {
		try {
			List<Mesas> mesas = new ArrayList<Mesas>();
		
			mesasRepository.findAll().forEach(mesas::add);			

			return new ResponseEntity<>(mesas, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/mesas/{id}")
	public ResponseEntity<Mesas> getmesasById(@PathVariable("id") long id) {
		Optional<Mesas> mesasData = mesasRepository.findById(id);

		if (mesasData.isPresent()) {
			return new ResponseEntity<>(mesasData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// @PostMapping("/mesas")
	// public ResponseEntity<Mesas> createTutorial(@RequestBody Mesas mesas) {
	// 	try {
	// 		Mesas _mesas = mesasRepository
	// 				.save(new Mesas(mesas.getTitle(), mesas.getDescription(), false));
	// 		return new ResponseEntity<>(_mesas, HttpStatus.CREATED);
	// 	} catch (Exception e) {
	// 		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	// 	}
	// }

	// @PutMapping("/mesas/{id}")
	// public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
	// 	Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

	// 	if (tutorialData.isPresent()) {
	// 		Tutorial _tutorial = tutorialData.get();
	// 		_tutorial.setTitle(tutorial.getTitle());
	// 		_tutorial.setDescription(tutorial.getDescription());
	// 		_tutorial.setPublished(tutorial.isPublished());
	// 		return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
	// 	} else {
	// 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// 	}
	// }

	// @DeleteMapping("/mesas/{id}")
	// public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
	// 	try {
	// 		tutorialRepository.deleteById(id);
	// 		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	// 	} catch (Exception e) {
	// 		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	// 	}
	// }

	// @DeleteMapping("/mesas")
	// public ResponseEntity<HttpStatus> deleteAllMesas() {
	// 	try {
	// 		tutorialRepository.deleteAll();
	// 		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	// 	} catch (Exception e) {
	// 		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	// 	}

	// }

	// @GetMapping("/tutorials/published")
	// public ResponseEntity<List<Tutorial>> findByPublished() {
	// 	try {
	// 		List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

	// 		if (tutorials.isEmpty()) {
	// 			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	// 		}
	// 		return new ResponseEntity<>(tutorials, HttpStatus.OK);
	// 	} catch (Exception e) {
	// 		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	// 	}
	// }

}

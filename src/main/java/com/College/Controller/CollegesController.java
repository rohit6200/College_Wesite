package com.College.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.College.Entity.Colleges;
import com.College.Service.CollegeService;

@RestController
@RequestMapping("/Collage")
public class CollegesController {

	public CollegeService collegeService;

	public CollegesController(CollegeService collegeService) {
		this.collegeService = collegeService;
	}

	@PostMapping
	public ResponseEntity<Colleges> createdCollege(@RequestBody Colleges colleges) {
		Colleges collegesCreate = collegeService.create(colleges);
		return new ResponseEntity<>(collegesCreate, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Colleges> getCollegeById(@PathVariable Long id) {
		Colleges college = collegeService.getById(id);

		if (college != null) {
			return new ResponseEntity<>(college, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(college, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public ResponseEntity<List<Colleges>> getAllCollege() {
		List<Colleges> colleges = collegeService.getAll();

		return new ResponseEntity<>(colleges, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Colleges> UpdateCollge(@PathVariable Long id, @RequestBody Colleges colleges) {
		Colleges extingColleges = collegeService.getById(id);

		if (extingColleges != null) {
			colleges.setId(id);

			Colleges upadtecollege = collegeService.update(colleges);
			return new ResponseEntity<>(upadtecollege, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Colleges> deletevalue(@PathVariable Long id) {
		Colleges collegedelete = collegeService.getById(id);
		if (collegedelete != null) {
			collegeService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

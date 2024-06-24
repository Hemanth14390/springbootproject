package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SchoolDto;
import com.example.demo.entity.School;
import com.example.demo.service.Schoolserviceimp;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController

public class SchoolController {
	@Autowired
	private Schoolserviceimp schoolserviceimp;
	@GetMapping
	 public ResponseEntity<List<School>> getAll() {
	     List<School> users = schoolserviceimp.getall();
	     return new ResponseEntity<>(users, HttpStatus.OK);
	 }
	 @GetMapping("/{id}")
	 public ResponseEntity<School> getById(@PathVariable Long id) {
		 School user = schoolserviceimp.getById(id);
	     if (user != null) {
	         return new ResponseEntity<>(user, HttpStatus.OK);
	     }
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }

	 @PostMapping
	 public ResponseEntity<School> create(@RequestBody SchoolDto userDTO) {
		 School createCustmer = schoolserviceimp.create(userDTO);
	     return new ResponseEntity<>(createCustmer, HttpStatus.CREATED);
	 }

	 @PutMapping("/{id}")
	 public ResponseEntity<School> update(@PathVariable Long id, @RequestBody SchoolDto userDTO) {
		 School update = schoolserviceimp.update(id, userDTO);
	     if (update != null) {
	         return new ResponseEntity<>(update, HttpStatus.OK);
	     }
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }

	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> delete(@PathVariable Long id) {
		 schoolserviceimp.delete(id);
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	
	
	
	

}

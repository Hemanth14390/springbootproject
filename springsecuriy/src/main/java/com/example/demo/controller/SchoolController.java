package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.School;
import com.example.demo.service.SchoolService;
@RestController
@RequestMapping("/api/school")
public class SchoolController {
	@Autowired
	private SchoolService schoolservice;
	
	@GetMapping("/school")
	public String school() {
		return "Hi Welcome to School";
	}

 @GetMapping("/fecth-all")
 @PreAuthorize("hasRole('USER')")
 public ResponseEntity<List<School>>fetchAll(){
	 List<School>school=schoolservice.getAll();
     return new ResponseEntity<>(school, HttpStatus.OK);
 }
 
 @GetMapping("/fetch/{id}")
 @PreAuthorize("hasRole('ADIMN')")
 public ResponseEntity<School> fetch(@PathVariable Long id) {
	 School school = schoolservice.getById(id);
     if (school != null) {
         return new ResponseEntity<>(school, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
}

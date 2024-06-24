package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.School;
import com.example.demo.repositry.SchoolRepositry;
@Service
public class SchoolService {
	@Autowired
	private SchoolRepositry schoolrepositry;
	
	public List<School>getAll(){
		return schoolrepositry.findAll();
	}
	public School getById(Long id) {
	    return schoolrepositry.findById(id).orElse(null);
	}
}

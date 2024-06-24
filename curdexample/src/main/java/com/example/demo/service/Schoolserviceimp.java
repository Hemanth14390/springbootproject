package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.SchoolDto;
import com.example.demo.entity.School;

public interface Schoolserviceimp {
	List<School>getall();
	School getById(Long id);
	School create(SchoolDto dto);
	School  update(Long id,SchoolDto dto);
	School delete(Long id);

}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SchoolDto;
import com.example.demo.entity.School;
import com.example.demo.repository.SchoolRepository;
@Service
public class SchoolService implements Schoolserviceimp {
    @Autowired
	 private SchoolRepository schoolrepository;
	@Override
	public List<School> getall() {
		return schoolrepository.findAll();
	}

	@Override
	public School getById(Long id) {
		return schoolrepository.findById(id).orElse(null);
	}

	@Override
	public School create(SchoolDto dto) {
		School school=new School();
		school.setName(dto.getName());
		school.setFee(dto.getFee());
		return schoolrepository.save(school);
	}

	@Override
	public School update(Long id, SchoolDto dto) {
		School school=schoolrepository.findById(id).orElse(null);
		if(school !=null) {
			school.setName(dto.getName());
			school.setFee(dto.getFee());
			return schoolrepository.save(school);
		}
		return null;
	}

	@Override
	public School delete(Long id) {
		 schoolrepository.deleteById(id);
		return null;
	}

}

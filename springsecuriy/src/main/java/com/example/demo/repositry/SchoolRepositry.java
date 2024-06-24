package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.School;


public interface SchoolRepositry extends JpaRepository<School, Long> {
    // Define custom query methods if needed
}

package com.unibe.edu.proyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibe.edu.proyect.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

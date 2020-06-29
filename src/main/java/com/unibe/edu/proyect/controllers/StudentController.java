package com.unibe.edu.proyect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.unibe.edu.proyect.dtos.StudentDto;
import com.unibe.edu.proyect.entity.Student;
import com.unibe.edu.proyect.repositories.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	public void createStudent(StudentDto studentDto) {
		Student student = new Student(studentDto.getId_student(), studentDto.getCi(), studentDto.getLastNames(),
				studentDto.getLastNames(), studentDto.getMail(), studentDto.getPhone(), studentDto.getBornDate(),
				studentDto.getAdress());

	}
}

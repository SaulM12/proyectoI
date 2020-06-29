package com.unibe.edu.proyect.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unibe.edu.proyect.controllers.StudentController;
import com.unibe.edu.proyect.dtos.StudentDto;
import com.unibe.edu.proyect.resources.exeptions.StudentCreateError;

@RestController
@RequestMapping(StudentResource.STUDENT)
public class StudentResource {
	
	public static final String STUDENT = "/students";
	
	@Autowired
	private StudentController studentController;
	
	@PostMapping
	public void createStudent(@Valid @RequestBody StudentDto studentDto )throws StudentCreateError {
		this.studentController.createStudent(studentDto);
		
	}

}
package com.unibe.edu.proyect.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unibe.edu.proyect.controllers.StudentController;
import com.unibe.edu.proyect.dtos.StudentDto;
import com.unibe.edu.proyect.resources.exeptions.StudentCreateError;
import com.unibe.edu.proyect.resources.exeptions.StudentDontFound;

@RestController
@RequestMapping(StudentResource.STUDENT)
public class StudentResource {
	
	public static final String STUDENT = "/students";
	public static final String ID="/{id}";
	
	@Autowired
	private StudentController studentController;
	
	@PostMapping
	public void createStudent(@Valid @RequestBody StudentDto studentDto )throws StudentCreateError {
		this.studentController.createStudent(studentDto);
		
	}
	@GetMapping
	public List<StudentDto> readAllStudents(){
		return this.studentController.readAllStudents();
	}	
	@GetMapping (value = ID)
	public StudentDto readStudentbyId(@PathVariable int id) throws StudentDontFound{
		return this.studentController.findStudentById(id).orElseThrow(()-> new StudentDontFound());
	}
}
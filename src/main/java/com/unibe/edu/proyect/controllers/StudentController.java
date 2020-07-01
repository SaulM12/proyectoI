package com.unibe.edu.proyect.controllers;

import java.util.ArrayList;
import java.util.List;

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
		this.studentRepository.save(student);

	}
	public List<StudentDto> readAllStudents(){
		List<Student> studentList= this.studentRepository.findAll();
		List<StudentDto> studentsDto= new ArrayList<StudentDto>();
		for(Student student: studentList) {
			studentsDto.add(new StudentDto(student));
		}
		return studentsDto;
		
	}
}

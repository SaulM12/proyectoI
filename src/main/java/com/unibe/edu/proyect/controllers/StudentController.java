package com.unibe.edu.proyect.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.unibe.edu.proyect.dtos.StudentDto;
import com.unibe.edu.proyect.entity.Student;
import com.unibe.edu.proyect.repositories.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	public Optional<Student> getStudentById(int id){
		Optional<Student> studOptional= this.studentRepository.findById(id);
		return studOptional;
	}

	public void createStudent(StudentDto studentDto) {
		Student student = new Student(studentDto.getId_student(), studentDto.getCi(), studentDto.getNames(),
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
	public Optional<StudentDto> findStudentById(int id){
		Optional<Student> estOptional= this.getStudentById(id);
		if(estOptional.isPresent()) {
			return Optional.of(new StudentDto(estOptional.get()));
		}else {
			return Optional.empty();
		}
	}
	public boolean editStudent(int id, StudentDto studentdto) {
		Optional<Student>studOptional= this.getStudentById(id);
		if(!studOptional.isPresent()) return false;
		Student student = studOptional.get();
		student.setCi(studentdto.getCi());
		student.setNames(studentdto.getNames());
		student.setLastNames(studentdto.getLastNames());
		student.setMail(studentdto.getMail());
		student.setPhone(studentdto.getPhone());
		student.setBornDate(studentdto.getBornDate());
		student.setAdress(studentdto.getAdress());
		this.studentRepository.save(student);
		return true;
		
	}
}

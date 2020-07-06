package com.unibe.edu.proyect.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.unibe.edu.proyect.dtos.InscriptionDto;
import com.unibe.edu.proyect.entity.Inscription;
import com.unibe.edu.proyect.entity.Student;
import com.unibe.edu.proyect.repositories.InscriptionRepository;

@Controller
public class InscriptionController {

	@Autowired
	private InscriptionRepository inscriptionRepository;
	@Autowired
	private StudentController studentController;

	public String createInscription(InscriptionDto inscriptionDto) {
		Optional<Student> studentOptional = this.studentController
				.getStudentById(inscriptionDto.getStudent().getId_student());
		if(!studentOptional.isPresent())
			return "student";
		Student student = studentOptional.get();
		Inscription inscription = new Inscription(inscriptionDto.getCod_insc(), inscriptionDto.getModality(), inscriptionDto.getDate(), inscriptionDto.getImage_ci(), inscriptionDto.getImage_title(), inscriptionDto.getImage_student(), inscriptionDto.getImage_voucher(), inscriptionDto.getImage_vote(),student);
		this.inscriptionRepository.save(inscription);
		return"Created";
	}
}

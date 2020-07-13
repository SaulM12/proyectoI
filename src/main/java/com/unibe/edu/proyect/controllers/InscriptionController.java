package com.unibe.edu.proyect.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.unibe.edu.proyect.dtos.InscriptionDto;
import com.unibe.edu.proyect.entity.Career;
import com.unibe.edu.proyect.entity.Inscription;
import com.unibe.edu.proyect.entity.Student;
import com.unibe.edu.proyect.repositories.InscriptionRepository;

@Controller
public class InscriptionController {

	@Autowired
	private InscriptionRepository inscriptionRepository;
	@Autowired
	private StudentController studentController;
	@Autowired
	private CareerController careerController;

	public Optional<Inscription> getInscriptionById(int id) {
		Optional<Inscription> inscOptional = this.inscriptionRepository.findById(id);
		return inscOptional;
	}

	public String createInscription(InscriptionDto inscriptionDto) {
		Optional<Student> studentOptional = this.studentController
				.getStudentById(inscriptionDto.getStudent().getId_student());
		if (!studentOptional.isPresent())
			return "student";
		Student student = studentOptional.get();
		Optional<Career> careerOptional = this.careerController
				.getCareerById(inscriptionDto.getCareer().getCod_career());
		if (!careerOptional.isPresent())
			return "career";
		Career career = careerOptional.get();
		Inscription inscription = new Inscription(inscriptionDto.getCod_insc(), inscriptionDto.getModality(),
				inscriptionDto.getDate(), inscriptionDto.getImage_ci(), inscriptionDto.getImage_title(),
				inscriptionDto.getImage_student(), inscriptionDto.getImage_voucher(), inscriptionDto.getImage_vote(),
				student, career);
		this.inscriptionRepository.save(inscription);
		return "created"; 
	}

	public List<InscriptionDto> readAllInscriptions() {
		List<Inscription> inscriptionList = this.inscriptionRepository.findAll();
		List<InscriptionDto> inscriptionListDto = new ArrayList<InscriptionDto>();
		for (Inscription inscription : inscriptionList) {
			inscriptionListDto.add(new InscriptionDto(inscription));
		}
		return inscriptionListDto;
	}

	public Optional<InscriptionDto> findInscriptionById(int id) {
		Optional<Inscription> inscrOptional = this.getInscriptionById(id);
		if (inscrOptional.isPresent()) {
			return Optional.of(new InscriptionDto(inscrOptional.get()));
		} else {
			return Optional.empty();
		}
	}

	public boolean editInscription(int id, InscriptionDto inscriptionDto) {
		Optional<Inscription> inscOptional = this.getInscriptionById(id);
		if (!inscOptional.isPresent())
			return false;
		Optional<Student> studOptional = this.studentController
				.getStudentById(inscriptionDto.getStudent().getId_student());
		if(!studOptional.isPresent())
			return false;
		Optional<Career> careerOptional= this.careerController
				.getCareerById(inscriptionDto.getCareer().getCod_career());
				if(!careerOptional.isPresent())
					return false;
		Inscription inscription = inscOptional.get();
		inscription.setModality(inscriptionDto.getModality());
		inscription.setDate(inscriptionDto.getDate());
		inscription.setImage_ci(inscriptionDto.getImage_ci());
		inscription.setImage_title(inscriptionDto.getImage_title());
		inscription.setImage_student(inscriptionDto.getImage_student());
		inscription.setImage_voucher(inscriptionDto.getImage_voucher());
		inscription.setImage_vote(inscriptionDto.getImage_vote());
		inscription.setStudent(studOptional.get());
		inscription.setCarrer(careerOptional.get());
		this.inscriptionRepository.save(inscription);
		return true;

	}

}

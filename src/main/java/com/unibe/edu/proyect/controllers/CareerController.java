package com.unibe.edu.proyect.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.unibe.edu.proyect.dtos.CareerDto;
import com.unibe.edu.proyect.entity.Career;
import com.unibe.edu.proyect.repositories.CareerRepository;

@Controller
public class CareerController {

	@Autowired
	private CareerRepository careerRepository;
	
	public Optional<Career> getCareerById(int id){
		Optional<Career> careerOptional= this.careerRepository.findById(id);
		return careerOptional;
	}

	public void createCareer(@Valid CareerDto careerDto) {
		Career career = new Career(careerDto.getCod_career(), careerDto.getDescription(), careerDto.getSemesters(), careerDto.getHours(), careerDto.getCredits());
		this.careerRepository.save(career);

	}
	public List<CareerDto> readAllCareers(){
		List<Career> careerList= this.careerRepository.findAll();
		List<CareerDto> careersDto= new ArrayList<CareerDto>();
		for(Career career: careerList) {
			careersDto.add(new CareerDto(career));
		}
		return careersDto;
		
	}
	public Optional<CareerDto> findCareerById(int id){
		Optional<Career> careerOptional= this.getCareerById(id);
		if(careerOptional.isPresent()) {
			return Optional.of(new CareerDto(careerOptional.get()));
		}else {
			return Optional.empty();
		}
	}
	public boolean editCareer(int id, CareerDto careerDto) {
		Optional<Career>careerOptional= this.getCareerById(id);
		if(!careerOptional.isPresent()) return false;
		Career career = careerOptional.get();
		career.setDescription(careerDto.getDescription());
		career.setSemesters(careerDto.getSemesters());
		career.setHours(careerDto.getHours());
		career.setCredits(careerDto.getCredits());
		this.careerRepository.save(career);
		return true;
		
	}
}

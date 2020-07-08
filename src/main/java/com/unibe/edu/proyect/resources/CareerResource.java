package com.unibe.edu.proyect.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unibe.edu.proyect.controllers.CareerController;
import com.unibe.edu.proyect.dtos.CareerDto;
import com.unibe.edu.proyect.resources.exeptions.CareerCreateError;
import com.unibe.edu.proyect.resources.exeptions.CareerDontFound;


@RestController
@RequestMapping(CareerResource.CAREER)
public class CareerResource {
	
	public static final String CAREER = "/careers";
	public static final String ID="/{id}";
	
	@Autowired
	private CareerController careerController;
	
	@PostMapping
	public void createCareer(@Valid @RequestBody CareerDto careerDto )throws CareerCreateError {
		this.careerController.createCareer(careerDto);
		
	}
	@GetMapping
	public List<CareerDto> readAllcareers(){
		return this.careerController.readAllCareers();
	}	
	@GetMapping (value = ID)
	public CareerDto readCareerById(@PathVariable int id) throws CareerDontFound{
		return this.careerController.findCareerById(id).orElseThrow(()-> new CareerDontFound());
	}
	@PutMapping (value= ID)
	public void editCareer(@PathVariable int id, @Valid @RequestBody CareerDto careerDto) throws CareerDontFound{
		if (!this.careerController.editCareer(id, careerDto)) throw new CareerDontFound();
	}
}

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

import com.unibe.edu.proyect.controllers.InscriptionController;
import com.unibe.edu.proyect.dtos.InscriptionDto;
import com.unibe.edu.proyect.resources.exeptions.CareerDontFound;
import com.unibe.edu.proyect.resources.exeptions.InscriptionCreateError;
import com.unibe.edu.proyect.resources.exeptions.InscriptionDontFound;
import com.unibe.edu.proyect.resources.exeptions.StudentDontFound;

@RestController
@RequestMapping(InscriptionResource.INSCRIPTION)
public class InscriptionResource {
	public static final String INSCRIPTION = "/inscriptions";
	public static final String ID = "/{id}";

	@Autowired
	private InscriptionController inscriptionController;

	@PostMapping
	public void createInscription(@Valid @RequestBody InscriptionDto inscriptionDto)
			throws InscriptionCreateError, StudentDontFound, CareerDontFound {
		if (this.inscriptionController.createInscription(inscriptionDto) == "student")
			throw new StudentDontFound();
		if (this.inscriptionController.createInscription(inscriptionDto) == "career")
			throw new CareerDontFound();
	}

	@GetMapping
	public List<InscriptionDto> readAllInscriptions() {
		return this.inscriptionController.readAllInscriptions();
	}

	@GetMapping(value = ID)
	public InscriptionDto readInscriptionByiD(@PathVariable int id) throws InscriptionDontFound {
		return this.inscriptionController.findInscriptionById(id).orElseThrow(() -> new InscriptionDontFound());
	}

	@PutMapping(value = ID)
	public void editInscription(@PathVariable int id, @Valid @RequestBody InscriptionDto inscriptionDto)
			throws InscriptionDontFound {
		if (!this.inscriptionController.editInscription(id, inscriptionDto))
			throw new InscriptionDontFound();

	}
}

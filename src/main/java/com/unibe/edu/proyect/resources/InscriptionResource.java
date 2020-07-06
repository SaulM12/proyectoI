package com.unibe.edu.proyect.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unibe.edu.proyect.controllers.InscriptionController;
import com.unibe.edu.proyect.dtos.InscriptionDto;
import com.unibe.edu.proyect.resources.exeptions.InscriptionCreateError;
import com.unibe.edu.proyect.resources.exeptions.StudentDontFound;

@RestController
@RequestMapping(InscriptionResource.INSCRIPTION)
public class InscriptionResource {
	public static final String INSCRIPTION =" /inscriptions";
	
	@Autowired
	private InscriptionController inscriptionController;
	
	@PostMapping
	public void createInscription(@Valid @RequestBody InscriptionDto inscriptionDto)
	throws InscriptionCreateError, StudentDontFound {
		if (this.inscriptionController.createInscription(inscriptionDto)=="student")
			throw new StudentDontFound();
	}
}


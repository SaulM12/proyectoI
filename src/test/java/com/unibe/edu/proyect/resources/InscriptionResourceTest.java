package com.unibe.edu.proyect.resources;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.unibe.edu.proyect.dtos.CareerDto;
import com.unibe.edu.proyect.dtos.InscriptionDto;
import com.unibe.edu.proyect.dtos.StudentDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class InscriptionResourceTest {

@Rule
public ExpectedException thrown= ExpectedException.none();

@Autowired
private RestService restservice;
private StudentDto studentDto;
private CareerDto careerDto;
private InscriptionDto inscriptionDto;

@Before
public void Before() {
	byte[]A= new byte[2];
	A[0] = 1;
	A[1]=2;
	this.studentDto = new StudentDto(1, "545", "SAMFDKS JNDJS", "SAKSM JSND", "SDLS", "545456", "2000-04-03",
			"SLKSDLKS");
	this.careerDto = new CareerDto(2, "Ingeniería en Software", 8, 2000,200);
	this.inscriptionDto = new InscriptionDto(2, "Presencial", "2020-08-12", A, A, A, A, A, this.studentDto, this.careerDto);
	}
	@Test
	public void createInscriptionTest() {
		restservice.restBuilder().path(InscriptionResource.INSCRIPTION).body(inscriptionDto).post().build();
	}
	@Test
	public void readAllInscriptionsTest() {
		String json= restservice.restBuilder(new RestBuilder<String>()).clazz(String.class)
				.path(InscriptionResource.INSCRIPTION).get().build();
		System.out.println("-->"+ json);
	}
	@Test
	public void readInscriptionByIdTest() {
		String json = restservice.restBuilder(new RestBuilder<String>()).clazz(String.class)
				.path(InscriptionResource.INSCRIPTION).path(InscriptionResource.ID).expand(1).get().build();
		System.out.println("-->"+ json);
	}
	@Test
	public void editInscriptionTest() {
		this.inscriptionDto.setModality("Semipresencial");
		this.careerDto.setCod_career(2);
		this.studentDto.setId_student(2);
		restservice.restBuilder().path(InscriptionResource.INSCRIPTION)
		.path(InscriptionResource.ID).expand(1).body(inscriptionDto).put().build();
	}
}

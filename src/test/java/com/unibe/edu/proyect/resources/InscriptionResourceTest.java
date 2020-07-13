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
	Byte[] A = new Byte[2];
	A[1] = 1;
	A[2]=2;
	this.studentDto = new StudentDto(1, "545", "SAMFDKS JNDJS", "SAKSM JSND", "SDLS", "545456", "2000-04-03",
			"SLKSDLKS");
	this.careerDto = new CareerDto(2, "Ingeniería en Software", 8, 2000,200);
	this.inscriptionDto = new InscriptionDto(1, "Presencial", "2020-08-12", A, A, A, A, A, this.studentDto, this.careerDto);
	}
	@Test
	public void test() {
		restservice.restBuilder().path(InscriptionResource.INSCRIPTION).body(inscriptionDto).post().build();
	}
}

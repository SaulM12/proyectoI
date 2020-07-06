package com.unibe.edu.proyect.resources;

import org.junit.Before;
import org.junit.Rule;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
private InscriptionDto inscriptionDto;

@Before
public void Before() {
	this.studentDto= new StudentDto(2, "", "", "", "", "", "", "");


		
	}
}

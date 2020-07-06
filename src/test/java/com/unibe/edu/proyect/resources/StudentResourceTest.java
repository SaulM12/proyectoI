package com.unibe.edu.proyect.resources;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.unibe.edu.proyect.dtos.StudentDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentResourceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private RestService restService;
	private StudentDto studentDto;

	@Before
	public void before() {
		this.studentDto = new StudentDto(1, "545", "SAMFDKS JNDJS", "SAKSM JSND", "SDLS", "545456", "2000-04-03",
				"SLKSDLKS");
	}

	@Test
	public void createStudentTest() {
		restService.restBuilder().path(StudentResource.STUDENT).body(studentDto).post().build();
	}
}
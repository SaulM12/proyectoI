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
		this.studentDto = new StudentDto(2, "5", "Carolina Emilia", "Lara Diaz", "CELD@gmail.com", "0969043552", "1999-04-03",
				"Colinas del Norte");
	}

	@Test
	public void createStudentTest() {
		restService.restBuilder().path(StudentResource.STUDENT).body(studentDto).post().build();
	}
	@Test
	public void readAllStudentsTest() {
		String json= restService.restBuilder(new RestBuilder<String>()).clazz(String.class).path(StudentResource.STUDENT).get().build();
		System.out.println("----->"+json);
	}
	@Test
	public void readStudentByIdTest() {
		String json= restService.restBuilder(new RestBuilder<String>()).clazz(String.class).path(StudentResource.STUDENT)
				.path(StudentResource.ID).expand(1).get().build();
		System.out.println("----->"+json);
	}
	@Test
	public void editStudentTest() {
		this.studentDto.setNames("Mateo Christopher");
		this.studentDto.setLastNames("Guaman Yacelga");
		this.studentDto.setAdress("Conocoto");
		this.studentDto.setMail("ll@gmail.com");
		restService.restBuilder().path(StudentResource.STUDENT)
		.path(StudentResource.ID).expand(1).body(studentDto).put().build();
	}
	
}

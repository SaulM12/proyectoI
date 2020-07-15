package com.unibe.edu.proyect.resources;

import static org.junit.Assert.*;

import org.junit.Test;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.unibe.edu.proyect.dtos.CareerDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CareerResourceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private RestService restService;
	private CareerDto careerDto;

	@Before
	public void before() {
		this.careerDto = new CareerDto(3, "Turismo", 8, 2500,220);
	}

	@Test
	public void createCareerTest() {
		restService.restBuilder().path(CareerResource.CAREER).body(careerDto).post().build();
	}
	@Test
	public void readAllCareersTest() {
		String json= restService.restBuilder(new RestBuilder<String>()).clazz(String.class).path(CareerResource.CAREER).get().build();
		System.out.println("----->"+json);
	}
	@Test
	public void readCareerByIdTest() {
		String json= restService.restBuilder(new RestBuilder<String>()).clazz(String.class).path(CareerResource.CAREER)
				.path(CareerResource.ID).expand(1).get().build();
		System.out.println("----->"+json);
	}
	@Test
	public void editCareerTest() {
		this.careerDto.setDescription("Ingeniería en Sistemas");
		String json=restService.restBuilder(new RestBuilder<String>()).clazz(String.class).path(CareerResource.CAREER)
		.path(CareerResource.ID).expand(1).body(careerDto).put().build();
		System.out.println(json);
	}
	
}

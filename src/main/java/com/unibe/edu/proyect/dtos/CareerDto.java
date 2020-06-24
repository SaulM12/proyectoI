package com.unibe.edu.proyect.dtos;

import com.unibe.edu.proyect.entity.Career;

public class CareerDto {

	private int cod_career;

	private String desscription;
	private int semesters;
	private int hours;
	private int  credits;
	public CareerDto(int cod_career, String desscription, int semesters, int hours, int credits) {
		super();
		this.cod_career = cod_career;
		this.desscription = desscription;
		this.semesters = semesters;
		this.hours = hours;
		this.credits = credits;
	}
	
	public CareerDto(Career career) {
		this.cod_career = career.getCod_career();
		this.desscription = career.getDesscription();
		this.semesters = career.getSemesters();
		this.hours = career.getHours();
		this.credits = career.getCredits();
	}

	public int getCod_career() {
		return cod_career;
	}

	public void setCod_career(int cod_career) {
		this.cod_career = cod_career;
	}

	public String getDesscription() {
		return desscription;
	}

	public void setDesscription(String desscription) {
		this.desscription = desscription;
	}

	public int getSemesters() {
		return semesters;
	}

	public void setSemesters(int semesters) {
		this.semesters = semesters;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

}

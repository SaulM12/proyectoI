package com.unibe.edu.proyect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Career {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int cod_career;

	private String desscription;
	private int semesters;
	private int hours;
	private int  credits;
	public Career(int cod_career, String desscription, int semesters, int hours, int credits) {
		super();
		this.cod_career = cod_career;
		this.desscription = desscription;
		this.semesters = semesters;
		this.hours = hours;
		this.credits = credits;
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

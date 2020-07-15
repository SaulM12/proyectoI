package com.unibe.edu.proyect.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Inscription {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int cod_insc;	

	private String modality;
	private String date;

	private String image_ci, image_title,image_student,image_voucher,image_vote;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Student student;
	@ManyToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Career carrer;
	
	public Inscription() {
		
	}

	public Inscription(int cod_insc, String modality, String date, String image_ci, String image_title,
			String image_student, String image_voucher, String image_vote, Student student, Career carrer) {
		super();
		this.cod_insc = cod_insc;
		this.modality = modality;
		this.date = date;
		this.image_ci = image_ci;
		this.image_title = image_title;
		this.image_student = image_student;
		this.image_voucher = image_voucher;
		this.image_vote = image_vote;
		this.student = student;
		this.carrer = carrer;
	}

	public int getCod_insc() {
		return cod_insc;
	}

	public void setCod_insc(int cod_insc) {
		this.cod_insc = cod_insc;
	}

	public String getModality() {
		return modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getImage_ci() {
		return image_ci;
	}

	public void setImage_ci(String image_ci) {
		this.image_ci = image_ci;
	}

	public String getImage_title() {
		return image_title;
	}

	public void setImage_title(String image_title) {
		this.image_title = image_title;
	}

	public String getImage_student() {
		return image_student;
	}

	public void setImage_student(String image_student) {
		this.image_student = image_student;
	}

	public String getImage_voucher() {
		return image_voucher;
	}

	public void setImage_voucher(String image_voucher) {
		this.image_voucher = image_voucher;
	}

	public String getImage_vote() {
		return image_vote;
	}

	public void setImage_vote(String image_vote) {
		this.image_vote = image_vote;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Career getCarrer() {
		return carrer;
	}

	public void setCarrer(Career carrer) {
		this.carrer = carrer;
	}
	
	

	
	
	

}

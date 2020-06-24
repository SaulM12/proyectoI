package com.unibe.edu.proyect.dtos;

import javax.persistence.Lob;

import com.unibe.edu.proyect.entity.Inscription;
import com.unibe.edu.proyect.entity.Student;

public class InscriptionDto {

	private int cod_insc;	
	private String modality;
	private String date;

	private Byte[] image_ci;

	private Byte[] image_title;

	private Byte[] image_student;

	private Byte[] image_voucher;

	private Byte[] image_vote;

	private StudentDto student;
	private CareerDto career;
	public InscriptionDto(int cod_insc, String modality, String date, Byte[] image_ci, Byte[] image_title,
			Byte[] image_student, Byte[] image_voucher, Byte[] image_vote, StudentDto student, CareerDto career) {
		
		this.cod_insc = cod_insc;
		this.modality = modality;
		this.date = date;
		this.image_ci = image_ci;
		this.image_title = image_title;
		this.image_student = image_student;
		this.image_voucher = image_voucher;
		this.image_vote = image_vote;
		this.student = student;
		this.career = career;
	}
	
	public InscriptionDto(Inscription inscription) {
		this.cod_insc = inscription.getCod_insc();
		this.modality = inscription.getModality();
		this.date = inscription.getDate();
		this.image_ci = inscription.getImage_ci();
		this.image_title = inscription.getImage_title();
		this.image_student = inscription.getImage_student();
		this.image_voucher = inscription.getImage_voucher();
		this.image_vote = inscription.getImage_voucher();
		this.student = new StudentDto(inscription.getStudent());
		this.career = new CareerDto(inscription.getCarrer());
		
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

	public Byte[] getImage_ci() {
		return image_ci;
	}

	public void setImage_ci(Byte[] image_ci) {
		this.image_ci = image_ci;
	}

	public Byte[] getImage_title() {
		return image_title;
	}

	public void setImage_title(Byte[] image_title) {
		this.image_title = image_title;
	}

	public Byte[] getImage_student() {
		return image_student;
	}

	public void setImage_student(Byte[] image_student) {
		this.image_student = image_student;
	}

	public Byte[] getImage_voucher() {
		return image_voucher;
	}

	public void setImage_voucher(Byte[] image_voucher) {
		this.image_voucher = image_voucher;
	}

	public Byte[] getImage_vote() {
		return image_vote;
	}

	public void setImage_vote(Byte[] image_vote) {
		this.image_vote = image_vote;
	}

	public StudentDto getStudent() {
		return student;
	}

	public void setStudent(StudentDto student) {
		this.student = student;
	}

	public CareerDto getCareer() {
		return career;
	}

	public void setCareer(CareerDto career) {
		this.career = career;
	}

}

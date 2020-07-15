package com.unibe.edu.proyect.dtos;

import com.unibe.edu.proyect.entity.Inscription;


public class InscriptionDto {

	private int cod_insc;	
	private String modality;
	private String date;

	private byte[] image_ci;

	private byte[] image_title;

	private byte[] image_student;

	private byte[] image_voucher;

	private byte[] image_vote;

	private StudentDto student;
	private CareerDto career;
	public InscriptionDto(int cod_insc, String modality, String date, byte[] image_ci, byte[] image_title,
			byte[] image_student, byte[] image_voucher, byte[] image_vote, StudentDto student, CareerDto career) {
		
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

	public byte[] getImage_ci() {
		return image_ci;
	}

	public void setImage_ci(byte[] image_ci) {
		this.image_ci = image_ci;
	}

	public byte[] getImage_title() {
		return image_title;
	}

	public void setImage_title(byte[] image_title) {
		this.image_title = image_title;
	}

	public byte[] getImage_student() {
		return image_student;
	}

	public void setImage_student(byte[] image_student) {
		this.image_student = image_student;
	}

	public byte[] getImage_voucher() {
		return image_voucher;
	}

	public void setImage_voucher(byte[] image_voucher) {
		this.image_voucher = image_voucher;
	}

	public byte[] getImage_vote() {
		return image_vote;
	}

	public void setImage_vote(byte[] image_vote) {
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

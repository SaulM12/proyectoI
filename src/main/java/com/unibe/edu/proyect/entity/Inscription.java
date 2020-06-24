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
	@Lob
	private Byte[] image_ci;
	@Lob
	private Byte[] image_title;
	@Lob
	private Byte[] image_student;
	@Lob
	private Byte[] image_voucher;
	@Lob
	private Byte[] image_vote;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Student student;
	@ManyToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Career carrer;
	
	public Inscription(int cod_insc, String modality, String date, Byte[] image_ci, Byte[] image_title,
			Byte[] image_student, Byte[] image_voucher, Byte[] image_vote) {
		super();
		this.cod_insc = cod_insc;
		this.modality = modality;
		this.date = date;
		this.image_ci = image_ci;
		this.image_title = image_title;
		this.image_student = image_student;
		this.image_voucher = image_voucher;
		this.image_vote = image_vote;
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

	

}

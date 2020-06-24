package com.unibe.edu.proyect.dtos;

import com.unibe.edu.proyect.entity.Student;

public class StudentDto {
	private int id_student;

	private String ci;
	private String names;
	private String lastNames;
	private String mail;
	private String phone;
	private String bornDate;
	private String adress;
	public StudentDto(int id_student, String ci, String names, String lastNames, String mail, String phone,
			String bornDate, String adress) {
		super();
		this.id_student = id_student;
		this.ci = ci;
		this.names = names;
		this.lastNames = lastNames;
		this.mail = mail;
		this.phone = phone;
		this.bornDate = bornDate;
		this.adress = adress;
	}
	
	public StudentDto(Student student) {
		this.id_student = student.getId_student();
		this.ci = student.getCi();
		this.names = student.getNames();
		this.lastNames = student.getLastNames();
		this.mail = student.getMail();
		this.phone = student.getPhone();
		this.bornDate = student.getBornDate();
		this.adress = student.getAdress();
		
	}

	public int getId_student() {
		return id_student;
	}

	public void setId_student(int id_student) {
		this.id_student = id_student;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastNames() {
		return lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBornDate() {
		return bornDate;
	}

	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	

}

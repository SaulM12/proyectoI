package com.unibe.edu.proyect.resources.exeptions;

public class StudentCreateError extends Exception{
	
	private static final long serialVersionUID = -7717691994704695707L;
	
	public static final String DESCRIPTION="Bad information send";
	
	public StudentCreateError() {
		super(DESCRIPTION);
	}
	
	public StudentCreateError(String message) {
		super(DESCRIPTION+""+message);
	}
	

}

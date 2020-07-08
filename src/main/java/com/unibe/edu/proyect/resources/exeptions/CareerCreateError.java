package com.unibe.edu.proyect.resources.exeptions;

public class CareerCreateError extends Exception {

private static final long serialVersionUID = -7717691994704695707L;
	
	public static final String DESCRIPTION="Bad information send";
	
	public CareerCreateError() {
		super(DESCRIPTION);
	}
	
	public CareerCreateError(String message) {
		super(DESCRIPTION+""+message);
	}

}

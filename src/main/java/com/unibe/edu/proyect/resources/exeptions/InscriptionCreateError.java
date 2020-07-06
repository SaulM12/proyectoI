package com.unibe.edu.proyect.resources.exeptions;

public class InscriptionCreateError extends Exception {
	private static final long serialVersionUID = -7717691994704695707L;
	
	public static final String DESCRIPTION = "Bad information send";

	public InscriptionCreateError() {
		super(DESCRIPTION);
		
	}
	public InscriptionCreateError(String message) {
		super(DESCRIPTION+""+message);
	}



}

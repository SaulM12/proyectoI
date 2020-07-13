package com.unibe.edu.proyect.resources.exeptions;

public class InscriptionDontFound extends  Exception {

	private static final long serialVersionUID = -7717691994704695707L;

	public static final String DESCRIPTION= "Inscription don´t found";
	
	public InscriptionDontFound() {
		super(DESCRIPTION);
	}
	public InscriptionDontFound(String message) {
		super(DESCRIPTION+" "+message);
	}
}

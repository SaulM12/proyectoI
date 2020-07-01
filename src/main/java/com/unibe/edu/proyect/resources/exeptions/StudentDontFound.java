package com.unibe.edu.proyect.resources.exeptions;

public class StudentDontFound extends Exception{
private static final long serialVersionUID = -7717691994704695707L;
	
	public static final String DESCRIPTION="Student don't found";
	
	public StudentDontFound() {
		super(DESCRIPTION);
	}
	
	public StudentDontFound(String message ) {
		super(DESCRIPTION + " " +message);
	}

}

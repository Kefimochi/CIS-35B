package exceptionPackage;

import java.io.PrintWriter;

public class ExceptionAuto extends Exception {
	private int errorNum;
	private String errorMsg;
	
	public ExceptionAuto() {
		errorNum = -1;
		matchError(errorNum);
	}
	
	public ExceptionAuto(int errorNum) {
		this.errorNum = errorNum;
		matchError(errorNum);
		fix(errorNum);
	}
	
	public String fix(int num) {
		ExceptionFixes t = new ExceptionFixes(num);
		return t.fixError(num);
	}
	
	public void matchError(int num) {
		switch (num) { 
        case 101: 
            errorMsg = "Missing file name"; 
            break; 
        case 201: 
        	errorMsg = "Missing base price"; 
            break; 
        case 301: 
        	errorMsg = "Missing array size"; 
            break; 
        case 401: 
        	errorMsg = "Missing option set data"; 
            break; 
        case 501: 
        	errorMsg = "Missing option data"; 
            break; 
        default: 
        	errorMsg = "Some unknown error occured!"; 
            break; 
        } 
	}
	
	public void log(int num) {
		System.out.printf("\n~~~~~~~Error number %d: %s\n", errorNum, errorMsg);
		PrintWriter writer = new PrintWriter("D:\\Coding Projects\\CIS 35B\\Lab 1\\data\\exception-log.txt", "UTF-8");
		writer.println("\n~~~~~~~Error number %d: %s\n", errorNum, errorMsg);
		writer.close();
	}
}

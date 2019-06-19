package exception;
import java.io.PrintWriter;

import exception.*;

public class ExceptionAuto extends Exception {
	private int errorNum;
	private String errorMsg;
	
	public ExceptionAuto() {
		this(-1);
	}
	
	public ExceptionAuto(int errorNum) {
		this.errorNum = errorNum;
		switch (errorNum) { 
	        case 101: 
	            errorMsg = "Missing file name"; 
	            break; 
	        case 201: 
	        	errorMsg = "Missing base price"; 
	            break; 
	        case 301: 
	        	errorMsg = "Missing option set array size"; 
	            break; 
	        case 401: 
	        	errorMsg = "Missing option set name"; 
	            break; 
	        case 501: 
	        	errorMsg = "Missing option name"; 
	            break; 
	        case -1: 
	        	errorMsg = "Some unknown error occured!"; 
	            break; 
		} 
		log();
	}
	
	public int getErrorNum() {
		return errorNum;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public void setErrorNum(int num) {
		errorNum = num;
	}
	
	public void setErrorMsg(String msg) {
		errorMsg = msg;
	}
	
	public String fix() {
		ExceptionFixes x = new ExceptionFixes();
		return x.fix();
	}
	
	public void log() {
		System.out.printf("\n~~~~~~~Error %d: %s\n", errorNum, errorMsg);
//		PrintWriter writer = new PrintWriter("D:\\Coding Projects\\CIS 35B\\Lab 1\\data\\exception-log.txt", "UTF-8");
//		writer.printf("\n~~~~~~~Error number %d: %s\n", errorNum, errorMsg);
//		writer.close();
	}
}

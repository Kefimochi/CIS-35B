package exceptions;
import java.util.Scanner;

import adapter.BuildAuto;
import adapter.CreatableAuto;

public class ExceptionFixes extends Exception { 
	public String fix() {
		System.out.printf("An error occured, please re-enter your information below:\n");
		Scanner ss = new Scanner(System.in);
    	String s = ss.nextLine();
		return s;
	}
}

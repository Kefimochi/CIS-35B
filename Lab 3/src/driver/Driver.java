package driver;
import java.util.HashMap;

import adapter.*;
import exceptions.ExceptionAuto;
import model.Automobile;
import util.FileIO;

public class Driver {
	public static void main(String [] args) {
		HashMap<String, Automobile> map = new HashMap<>();
		//map.put(K, V)
		
//		To acess and store value
		// boolean containsKey(Object key) && containsVa;ue
//		Integer a = map.get("vishal"); 
//         System.out.println("value for key \"vishal\" is:- " + a); 
		
		CreatableAuto a1 = new BuildAuto(); // call .put() in build auto
		try {
			try {
				a1.BuildAuto("D:\\Coding Projects\\CIS 35B\\Lab 3\\data\\" 
						+ "TARDIS.txt", map);
				
				a1.printAuto("ModelName");	
			} catch (NullPointerException e) {
				throw new ExceptionAuto();
			}	
		} catch (ExceptionAuto e) {
			FixableAuto a3 = new BuildAuto();
			a3.fix(); //Don't forget to write fix
		}
		
		
		//Choose option choices
		
//		System.out.printf("\n~~~~~~~~~~~~"
//				+ "Data from the text file:\n");
//		car.print();
//		
//		System.out.printf("\n~~~~~~~~~~~~"
//				+ "Data from the serialized file:\n");
//		f.serialize(car, "D:\\Coding Projects\\CIS 35B\\Lab 1\\data\\newZagoon.ser");
//		Automobile newCar = f.deserialize("D:\\Coding Projects\\CIS 35B\\Lab 1\\data\\newZagoon.ser");
//		newCar.print();
	}
}

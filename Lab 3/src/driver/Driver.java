package driver;
import java.util.LinkedHashMap;

import adapter.*;
import exceptions.ExceptionAuto;
import model.Automobile;
import util.FileIO;

public class Driver {
	public static void main(String [] args) {
		LinkedHashMap<String, Automobile> map = new LinkedHashMap<>();
		//map.put(K, V)
		
//		To acess and store value
		// boolean containsKey(Object key) && containsVa;ue
		
		BuildAuto a1 = new BuildAuto(); 
		BuildAuto a2 = new BuildAuto();
		BuildAuto a3 = new BuildAuto();
		try {
			try {
				a1.BuildAuto("D:\\Coding Projects\\CIS 35B\\Lab 3\\data\\" 
						+ "ford_wagon_ztw.txt", map);
				a2.BuildAuto("D:\\Coding Projects\\CIS 35B\\Lab 3\\data\\" 
						+ "TARDIS.txt", map);
				a3.BuildAuto("D:\\Coding Projects\\CIS 35B\\Lab 3\\data\\" 
						+ "ford_zagoon_pro.txt", map);

				a2.chooseOption("modelName", "Color", "Deep Blue");
				a2.chooseOption("modelName", "Functionality", "Traveling in time");
				a2.chooseOption("modelName", "Doctor as companion", "Yes");
				map.entrySet().forEach(entry -> {
					// Functions like map.get("Ford ZagoonPro").print();
					if (!entry.equals(null)) map.get(entry.getKey()).print();
		        });
			} catch (NullPointerException e) {
				throw new ExceptionAuto(); // Throws unknown error
			}	
		} catch (ExceptionAuto e) {
			FixableAuto a5 = new BuildAuto();
			a5.fix(); //Don't forget to write fix
		}
			
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

package driver;
import adapter.*;
import exceptions.ExceptionAuto;
import model.Automobile;
import util.FileIO;

public class Driver {
	public static void main(String [] args) {
		CreatableAuto a1 = new BuildAuto();
		try {
			try {
				a1.BuildAuto("D:\\Coding Projects\\CIS 35B\\Lab 3\\data\\" 
						+ "TARDIS.txt");
				
				a1.printAuto("ModelName");	
			} catch (NullPointerException e) {
				throw new ExceptionAuto();
			}	
		} catch (ExceptionAuto e) {
			FixableAuto a3 = new BuildAuto();
			a3.fix(); //Don't forget to write fix
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

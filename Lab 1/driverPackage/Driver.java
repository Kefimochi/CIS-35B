package driverPackage;
import modelPackage.Automotive;
import utilPackage.FileIO;

public class Driver {
	public static void main(String [] args) {
		FileIO f = new FileIO();
		Automotive car = f.readFile("D:\\Coding Projects\\CIS 35B\\Lab 1\\data\\" 
		+ "ford_zagoon_pro.txt");
		System.out.printf("\n~~~~~~~~~~~~"
				+ "Data from the text file:\n");
		car.print();
		
		System.out.printf("\n~~~~~~~~~~~~"
				+ "Data from the serialized file:\n");
		f.serialize(car, "D:\\Coding Projects\\CIS 35B\\Lab 1\\data\\newZagoon.ser");
		Automotive newCar = f.deserialize("D:\\Coding Projects\\CIS 35B\\Lab 1\\data\\newZagoon.ser");
		newCar.print();
	}
}

package utilPackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import modelPackage.Automotive;

public class FileIO implements Serializable {
	public Automotive readFile(String fileName) {
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader buff = new BufferedReader(file);
			
			// Read basic info and create the car
			String name = buff.readLine();
			double price = Double.parseDouble(
					buff.readLine());
			int optionSetsSize = Integer.parseInt(
					buff.readLine());
			Automotive myCar = new Automotive(
					name, price, optionSetsSize);
			
			// Read each OptionSet
			for (int i = 0; i < optionSetsSize; i++) {
				buff.readLine(); // Skip a line
				name = buff.readLine();
				int optionsSize = Integer.parseInt(
						buff.readLine());
				myCar.makeOptionSet(i, name, optionsSize);
				// Read each Option
				for (int j = 0; j < optionsSize; j++) {
					name = buff.readLine();
					price = Integer.parseInt(buff.readLine());
					myCar.makeOption(i, j, name, price);
				}
			}
			buff.close();
			file.close();
			// Return the car
			return myCar;
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public void serialize(Automotive car, String fileName) {
		try {
			FileOutputStream f = new FileOutputStream(fileName);
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Writes objects to file
			o.writeObject(car);

			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			System.out.printf("File not found");
		} catch (IOException e) {
			System.out.printf("Error initializing stream");
		}
	}
	
	public Automotive deserialize(String fileName) {
		try {
			FileInputStream fi = new FileInputStream(fileName);
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			Automotive car = (Automotive) oi.readObject();

			oi.close();
			fi.close();
			return car;
		} catch (FileNotFoundException e) {
			System.out.printf("File not found");
		} catch (IOException e) {
			System.out.printf("Error initializing stream");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}

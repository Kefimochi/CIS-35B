package util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import exceptions.*;
import model.Automobile;

public class FileIO {
	public Automobile readFile(String fileName) throws ExceptionAuto {
		try {
			FileReader file = null;
			BufferedReader buff = null;
			double price = 0;
			String name = "";
			int optionSetsSize = 0;
			FileWriter writer = new FileWriter("D:\\Coding Projects\\CIS 35B\\Lab 2\\data\\exception-log.txt");
			PrintWriter w = new PrintWriter(writer);
			
			
			try {
				try {
					file = new FileReader(fileName);
					buff = new BufferedReader(file);
				} catch(IOException event) {
					throw new ExceptionAuto(101);
				}
			} catch (ExceptionAuto e) {
				file = new FileReader(e.fix());
				buff = new BufferedReader(file);
				log(w, e);
			}
			
			name = buff.readLine();
			
			try {
				String temp = buff.readLine();
					if (temp.equals("")) {
						throw new ExceptionAuto(201);
					} else {
						price = Double.parseDouble(temp);	
					}
			} catch (ExceptionAuto e) {
			//log (d error num & name s, double, string) => new doc write, don't forget to close
				price = Double.parseDouble(e.fix());
				log(w, e);
			}
			
			try {
				String temp = buff.readLine();
				if (temp.equals("")) {
					throw new ExceptionAuto(301);
				} else {
					optionSetsSize = Integer.parseInt(temp);	
				}
			} catch (ExceptionAuto e) {
				optionSetsSize = Integer.parseInt(e.fix());
				log(w, e);
			}
			
			Automobile myCar = new Automobile(
					name, price, optionSetsSize);
			
			for (int i = 0; i < optionSetsSize; i++) {
				buff.readLine(); // Skip a line
				
				try {
					String temp = buff.readLine();
					if (temp.equals("")) {
						throw new ExceptionAuto(401);
					} else {
						name = temp;	
					}
				} catch (ExceptionAuto e) {
					name = e.fix();
					log(w, e);
				}
//				name = buff.readLine();
				
				int optionsSize = Integer.parseInt(
						buff.readLine());
				myCar.makeOptionSet(i, name, optionsSize);

				for (int j = 0; j < optionsSize; j++) {
					try {
						String temp = buff.readLine();
						if (temp.equals("")) {
							throw new ExceptionAuto(501);
						} else {
							name = temp;	
						}
					} catch (ExceptionAuto e) {
						name = (e.fix());
						log(w, e);
					}
					price = Integer.parseInt(buff.readLine());
					myCar.makeOption(i, j, name, price);
				}
			}
			buff.close();
			file.close();
			w.close();
			writer.close();
			return myCar;
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public void serialize(Automobile car, String fileName) {
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
	
	public Automobile deserialize(String fileName) {
		try {
			FileInputStream fi = new FileInputStream(fileName);
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			Automobile car = (Automobile) oi.readObject();

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
	
	public void log(PrintWriter w, ExceptionAuto e) {
		w.printf("~~~~~~~Error %d: %s\n", e.getErrorNum(), e.getErrorMsg());
	}
}

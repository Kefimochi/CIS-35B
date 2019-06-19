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

import exception.*;
import model.Automobile;

public class FileIO {
	public Automobile readFile(String fileName) throws ExceptionAuto {
		try {
			FileReader file = null;
			BufferedReader buff = null;
			double basePrice = 0;
			double price = 0;
			String name = "";
			String optionName = "";
			FileWriter writer = new FileWriter("D:\\Coding Projects\\CIS 35B\\Lab 5\\data\\exception-log.txt");
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
						basePrice = Double.parseDouble(temp);	
					}
			} catch (ExceptionAuto e) {
				basePrice = Double.parseDouble(e.fix());
				log(w, e);
			}
			
			Automobile myCar = new Automobile(
					name, basePrice);
			int i = 0;
			boolean eof = false;
			buff.readLine(); // Skip a line
			while (!eof) {
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
				myCar.addOptionSet(name);
				optionName = buff.readLine();
				while(!optionName.equals("****************") && !optionName.equals(" ")) {
					price = Integer.parseInt(buff.readLine());
					myCar.addOption(i, optionName, price);
					
					optionName = buff.readLine();
				}
				i++;
				if (optionName == null || optionName.equals(" ")) {
					eof = true;
					optionName = "";
					break;
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

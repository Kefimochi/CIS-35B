package driver;
import java.util.LinkedHashMap;

import adapter.*;
import exceptions.ExceptionAuto;
import model.Automobile;
import util.FileIO;

public class Driver {
	public static void main(String [] args) {
		LinkedHashMap<String, Automobile> map = new LinkedHashMap<>();

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

				a1.chooseOption("modelName", "Color", "Ultra-Violet Dirtycoat");
				a1.chooseOption("modelName", "Transmission", "Manual");
				a1.chooseOption("modelName", "Brakes/Traction Control", "ABS with Advance Trac");
				a1.chooseOption("modelName", "Side Impact Air Bags", "If selected");
				a1.chooseOption("modelName", "Power Moonroof", "If none");
				
				a2.chooseOption("modelName", "Color", "Deep Blue");
				a2.chooseOption("modelName", "Functionality", "Traveling in time");
				a2.chooseOption("modelName", "Doctor as companion", "Yes");
				
				a3.chooseOption("modelName", "Color", "Metallic");
				a3.chooseOption("modelName", "Transmission", "Automatic");
				a3.chooseOption("modelName", "Brakes/Traction Control", "ABS");
				a3.chooseOption("modelName", "Side Impact Air Bags", "None");
				a3.chooseOption("modelName", "Power Moonroof", "Selected");
				
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
	}
}

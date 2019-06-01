package driver;

import java.util.LinkedHashMap;

import adapter.*;
import exception.ExceptionAuto;
import model.*;
import util.FileIO;

public class Driver {

	public static void main(String[] args) {
		BuildAuto a1 = new BuildAuto();
		a1.buildAuto("Ford Wagon ZTW", "D:\\Coding Projects\\CIS 35B\\Lab 4\\data\\" 
				+ "ford_wagon_ztw.txt");
		a1.buildAuto("TARDIS", "D:\\Coding Projects\\CIS 35B\\Lab 4\\data\\" 
				+ "TARDIS.txt");
		a1.buildAuto("Ford Zagoon Pro", "D:\\Coding Projects\\CIS 35B\\Lab 4\\data\\" 
				+ "ford_zagoon_pro.txt");
		
		a1.chooseOption("Ford Wagon ZTW", "Color", "Ultra-Violet Dirtycoat");
		a1.chooseOption("Ford Wagon ZTW", "Transmission", "Manual");
		a1.chooseOption("Ford Wagon ZTW", "Brakes/Traction Control", "ABS with Advance Trac");
		a1.chooseOption("Ford Wagon ZTW", "Side Impact Air Bags", "If selected");
		a1.chooseOption("Ford Wagon ZTW", "Power Moonroof", "If none");
		a1.printAuto("Ford Wagon ZTW");
		
		a1.chooseOption("TARDIS", "Color", "Deep Blue");
		a1.chooseOption("TARDIS", "Functionality", "Traveling in time");
		a1.chooseOption("TARDIS", "Doctor as companion", "Yes");
		a1.printAuto("TARDIS");
		
		a1.chooseOption("Ford Zagoon Pro", "Color", "Metallic");
		a1.chooseOption("Ford Zagoon Pro", "Transmission", "Automatic");
		a1.chooseOption("Ford Zagoon Pro", "Brakes/Traction Control", "ABS");
		a1.chooseOption("Ford Zagoon Pro", "Side Impact Air Bags", "None");
		a1.chooseOption("Ford Zagoon Pro", "Power Moonroof", "Selected");
		a1.printAuto("Ford Zagoon Pro");
	}

}











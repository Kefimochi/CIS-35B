package driver;

import java.util.LinkedHashMap;

import adapter.*;
import exception.ExceptionAuto;
import model.*;
import util.FileIO;

public class Driver {

	public static void main(String[] args) {
		BuildAuto a1 = new BuildAuto();
		a1.buildAuto("Ford Wagon ZTW", "D:\\Coding Projects\\CIS 35B\\Lab 5\\data\\" 
				+ "ford_wagon_ztw.txt");
		a1.buildAuto("TARDIS", "D:\\Coding Projects\\CIS 35B\\Lab 5\\data\\" 
				+ "TARDIS.txt");
		a1.buildAuto("Ford Zagoon Pro", "D:\\Coding Projects\\CIS 35B\\Lab 5\\data\\" 
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
		
		ScaleableAuto a2 = new BuildAuto();
		
		// Edit Ford Zagoon Pro
		a2.addOptionSet("Ford Zagoon Pro", "Audio System");
		a2.removeOptionSet("Ford Zagoon Pro", "Color");
		a2.addOption("Ford Zagoon Pro", "Audio System", "Dolby Digital", 1000);
		a2.removeOption("Ford Zagoon Pro", "Transmission", "Automatic");
		a2.addOption("Ford Zagoon Pro", "Audio System", "3D Acustic", 800);
		a2.updateOptionSetName("Ford Zagoon Pro", "Color", "Colour");
		a2.updateOptionPrice("Ford Zagoon Pro", "Transmission", "Standard", 0);
		// Display final result
		System.out.printf("\n______________________________________________________Edited Auto");
		a1.printAuto("Ford Zagoon Pro");	
				
		// Edit Ford Wagon ZTW
		a2.addOptionSet("Ford Wagon ZTW", "QWERTY");
		a2.removeOptionSet("Ford Wagon ZTW", "Power Moonroof");
		a2.addOption("Ford Wagon ZTW", "QWERTY", "Great", 1234);
		a2.updateOptionSetName("Ford Wagon ZTW", "QWERTY", "Sound Quality");
		a2.updateOptionPrice("Ford Wagon ZTW", "Sound Quality", "Great", 9876);
		// Display final result
		System.out.printf("\n______________________________________________________Edited Auto");
		a1.printAuto("Ford Wagon ZTW");
		
	}

}
package adapter;

import java.util.LinkedHashMap;

import exception.ExceptionAuto;
import model.*;
import util.FileIO;

public abstract class ProxyAutomobile {
	
	private static LinkedHashMap<String, Automobile> a1 = 
			new LinkedHashMap<String, Automobile>();
	
	public void buildAuto(String carName, String fileName) {
		FileIO f = new FileIO();
		try {
			a1.put(carName, f.readFile(fileName));
		} catch (ExceptionAuto e) {
			e.printStackTrace();
		}
	}
	
	public void printAuto(String carName) {
		a1.get(carName).print();
	}
	
	public void addOptionSet(String carName, String optionSetName) {
		a1.get(carName).addOptionSet(optionSetName);
	}
	
	public void removeOptionSet(String carName, String optionSetName) {
		a1.get(carName).deleteOptionSet(optionSetName);
	}
	
	public void addOption(String carName, String optionSetName, String OptionName, double optionPrice) {
		a1.get(carName).addOption(a1.get(carName).findOptionSetIndex(optionSetName), OptionName, optionPrice);
	}
	
	public void removeOption(String carName, String optionSetName, String OptionName) {
		a1.get(carName).deleteOption(optionSetName, OptionName);
	}
	
	public void updateOptionSetName(String carName,
			String optionSetName, String newOptionSetName) {
		a1.get(carName).updateOptionSetName(optionSetName, newOptionSetName);
	}
	
	public void updateOptionPrice(String carName,
			String optionSetName, String optionName, 
			double newPrice) {
		a1.get(carName).updateOptionPrice(optionSetName, optionName, newPrice);
	}
	
	public void fix() {
		// Handles external exception
	}
	
	public void chooseOption(String carName, String optionSetName,
			String optionName) {
		a1.get(carName).setOptionChoice(optionSetName, optionName);
	}
	
	public void printOptionChoices(String carName) {
		a1.get(carName).printChoices();
	}
	
}











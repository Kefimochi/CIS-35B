package adapter;
import java.io.File;

import exceptions.ExceptionAuto;
import model.*;
import util.FileIO;

public abstract class ProxyAutomobile {
	private static Automobile a1;
	
	public void updateOptionSetName(String modelName, String optionSetName, String
			newName) {
		a1.updateOptionSetName(optionSetName, newName);
	}
	
	public void updateOptionPrice(String modelName, String optionSetName, String
			optionName, float newPrice) {
		a1.updateOptionPrice(optionSetName, optionName, newPrice);
	}
	
	public void BuildAuto(String fileName) {
		FileIO f = new FileIO();
		try {
			a1 = f.readFile(fileName);	
		} catch (ExceptionAuto e) {
			e.printStackTrace();
		}
	}
	
	public void printAuto(String Modelname) {
		a1.print();
	}
	
	public void fix() {}
}
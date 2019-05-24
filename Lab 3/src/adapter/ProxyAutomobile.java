package adapter;
import java.io.File;
import java.util.LinkedHashMap;
import exceptions.ExceptionAuto;
import model.*;
import util.FileIO;

public abstract class ProxyAutomobile {
	private Automobile a1;
	
	public void updateOptionSetName(String modelName, String optionSetName, String
			newName) {
		a1.updateOptionSetName(optionSetName, newName);
	}
	
	public void updateOptionPrice(String modelName, String optionSetName, String
			optionName, float newPrice) {
		a1.updateOptionPrice(optionSetName, optionName, newPrice);
	}
	
	public void chooseOption(String modelName, String optionSetName, String optionName) {
		System.out.print("\nU MADE IT\n");
		a1.setOptionChoice(optionSetName, optionName);
	}
	
	public void BuildAuto(String fileName, LinkedHashMap<String, Automobile> map) {
		FileIO f = new FileIO();
		try {
			a1 = f.readFile(fileName);	
			map.put(a1.getName(), a1);
		} catch (ExceptionAuto e) {
			e.printStackTrace();
		}
	}
	
	public void printAuto(String Modelname) {
		a1.print();
	}
	
	public void fix() {}
}
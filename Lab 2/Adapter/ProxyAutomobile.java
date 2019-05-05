package adapterPackage;
import java.io.File;
import exceptionPackage.ExceptionAuto;
import modelPackage.*;
import utilPackage.FileIO;

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
		File tempFile = new File(fileName);
		try {
			if (tempFile.exists()) a1 = f.readFile(fileName);
			else throw new ExceptionAuto(101);		
		} catch (ExceptionAuto e) {
			a1 = f.readFile(fileName);
		}
	}
	
	public void printAuto(String Modelname) {
		a1.print();
	}
}

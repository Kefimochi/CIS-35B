package Adapter;
import modelPackage.*;
import utilPackage.FileIO;

public abstract class proxyAutomobile {
	private static Automobile a1;
	
	public void updateOptionSetName(String Modelname, String OptionSetname, String
			newName) {
		a1.updateOptionSetName(OptionSetname, newName); //  <----------------------------
	}
	
	public void updateOptionPrice(String Modelname, String Optionname, String
			Option, float newprice) {
		a1.updateOptionPrice(Modelname, Optionname, newprice);
	}
	
	public void BuildAuto(String fileName) {
		FileIO f = new FileIO();
		a1 = f.readFile(fileName);
	}
	
	public void printAuto(String Modelname) {
		a1.print();
	}
}

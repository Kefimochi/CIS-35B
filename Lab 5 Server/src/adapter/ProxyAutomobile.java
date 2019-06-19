package adapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Properties;

import server.DefaultServerSocket;
import server.DefaultSocketClient;
import exception.ExceptionAuto;
import model.*;
import scale.editOptions;
import util.FileIO;

public abstract class ProxyAutomobile implements ScaleableAuto, ServableAuto {
	
	private static LinkedHashMap<String, Automobile> a1 = 
			new LinkedHashMap<String, Automobile>();
	private ArrayList<String> modelNames = new ArrayList<String>();
	
//	public synchronized void buildAuto(String carName, String fileName) {
//		FileIO f = new FileIO();
//		try {
//			a1.put(carName, f.readFile(fileName)); 
//			modelNames.add(carName);
//		} catch (ExceptionAuto e) {
//			e.printStackTrace();
//		}
//	}
	
	public synchronized Automobile buildAuto(Object obj) throws ExceptionAuto {
		FileIO f = new FileIO();
		Automobile auto = null;
		try {
			auto = f.readPropsFile(obj);
		} catch (ExceptionAuto e) {
			e.printStackTrace();
		}
		
		a1.put(auto.getName(), auto); 
		modelNames.add(auto.getName());
		
		return auto;
	}
	
	public synchronized void printAuto(String carName) {
		a1.get(carName).print();
	}
	
	public synchronized void fix() {
		// Handles external exception
	}
	
	public synchronized void chooseOption(String carName, String optionSetName,
			String optionName) {
		a1.get(carName).setOptionChoice(optionSetName, optionName);
	}
	
	public synchronized void printOptionChoices(String carName) {
		a1.get(carName).printChoices();
	}
	
	public  void addOptionSet(String carName, String optionSetName) {
		editOptions editOpt = new editOptions() {
			public void run() {
				a1.get(carName).addOptionSet(optionSetName);
			}
		};
		Thread t = new Thread(editOpt);
		t.start();
		try { t.join(); } catch (InterruptedException e) { e.printStackTrace(); }
	}
	
	public void removeOptionSet(String carName, String optionSetName) {
		editOptions editOpt = new editOptions() {
			public void run() {
				a1.get(carName).deleteOptionSet(optionSetName);
			}
		};
		Thread t = new Thread(editOpt);
		t.start();
		try { t.join(); } catch (InterruptedException e) { e.printStackTrace(); }
	}
	
	public void addOption(String carName, String optionSetName, String OptionName, double optionPrice) {
		editOptions editOpt = new editOptions() {
			public void run() {
				a1.get(carName).addOption(a1.get(carName).findOptionSetIndex(optionSetName), OptionName, optionPrice);
			}
		};
		Thread t = new Thread(editOpt);
		t.start();
		try { t.join(); } catch (InterruptedException e) { e.printStackTrace(); }
	}
	
	public void removeOption(String carName, String optionSetName, String OptionName) {
		editOptions editOpt = new editOptions() {
			public void run() {
				a1.get(carName).deleteOption(optionSetName, OptionName);
			}
		};
		Thread t = new Thread(editOpt);
		t.start();
		try { t.join(); } catch (InterruptedException e) { e.printStackTrace(); }
	}
	
	public void updateOptionSetName(String carName,
			String optionSetName, String newOptionSetName) {
		editOptions editOpt = new editOptions() {
			public void run() {
				a1.get(carName).updateOptionSetName(optionSetName, newOptionSetName);
			}
		};
		Thread t = new Thread(editOpt);
		t.start();
		try { t.join(); } catch (InterruptedException e) { e.printStackTrace(); }
	}
	
	public void updateOptionPrice(String carName,
			String optionSetName, String optionName, 
			double newPrice) {
		editOptions editOpt = new editOptions() {
			public void run() {
				a1.get(carName).updateOptionPrice(optionSetName, optionName, newPrice);
			}
		};
		Thread t = new Thread(editOpt);
		t.start();
		try { t.join(); } catch (InterruptedException e) { e.printStackTrace(); }
	}

	public void serve(int port) {
		ServerInterface in = new DefaultServerSocket(port);
		in.run();
	}

	public String getAllModels() {
		String names = " ";
		for(int i = 0; i < modelNames.size(); i++) {
			names += modelNames.get(i) + " ";
		}
		return names;
	}	
}



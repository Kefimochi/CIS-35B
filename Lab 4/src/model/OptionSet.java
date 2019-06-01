package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OptionSet implements Serializable {
	
	private String name;
	private List<Option> options;
	private Option choice;
	
	protected OptionSet() {
		name = "";
		options = new ArrayList<OptionSet.Option>();
	}

	protected OptionSet(String name) {
		this.name = name;
		options = new ArrayList<OptionSet.Option>();
	}
	
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected Option getOptions(int i) {
		return options.get(i);
	}

	protected void setOptions(List options) {
		this.options = options;
	}
	
	protected Option getChoice() {
		return choice;
	}
	
	protected void setChoice(String optionName) {
		choice = findOption(optionName);
	}
	
//	protected void makeOptionsArray(int size) {
//		options = new Option[size];
//		for (int j = 0; j < size; j++)
//			options[j] = new Option();
//	}
	
	protected void addOption(String optionName, 
			double price) {
		options.add(new Option(optionName, price));
	}
	
	protected int findOptionIndex(String optionName) {
		if (!isOptionsEmpty()) {
			for (int i = 0; i < options.size(); i++) {
				if (options.get(i) != null && 
						options.get(i).getName().equals(optionName)) 
					return i;
			}
		}
		return -1;
	}
	
	protected Option findOption(String optionName) {
		Option myOption = new Option();
		int index = findOptionIndex(optionName);
		myOption = (index != -1) ? options.get(index) : null;
		return myOption;
	}
	
	protected void deleteOption(String optionName) {
		int index = findOptionIndex(optionName);
		if (index != -1)
			options.set(index, null);
	}
	
	protected void updateOption(String optionName, 
			Option newOption) {
		int index = findOptionIndex(optionName);
		if (index != -1)
			options.set(index, newOption);
	}
	
	protected void updateOptionName(String optionName,
			String newOptionName) {
		int index = findOptionIndex(optionName);
		if (index != -1)
			options.get(index).setName(newOptionName);
	}
	
	protected void updateOptionPrice(String optionName,
			double newPrice) {
		int index = findOptionIndex(optionName);
		if (index != -1)
			options.get(index).setPrice(newPrice);
	}
	
	protected boolean isOptionsEmpty() {
		return options.isEmpty();
	}
	
	protected void print() {
    	System.out.printf("*********%s*********\n", name);
    	if (!isOptionsEmpty()) {
    		for(int i = 0; i < options.size(); i++) {
            	if (options.get(i) != null) options.get(i).print();
            }	
    	}
    	if (choice != null)
    		System.out.printf("~~~~~~Option choice: %s\n\n", choice.getName());
    }

	//***** Inner Class *******
	class Option implements Serializable {
		
		private String name;
		private double price;
		
		protected Option() {
			name = "";
			price = 0;
		}
		
		protected Option(String name, double price) {
			this.name = name;
			this.price = price;
		}
		
		protected String getName() {
			return name;
		}
		
		protected void setName(String name) {
			this.name = name;
		}
		
		protected double getPrice() {
			return price;
		}
		
		protected void setPrice(double price) {
			this.price = price;
		}
		
		protected void print() {
            System.out.printf("~ %s: $%.2f\n", name, price);
        }
		
	}
	
}










package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Automobile implements Serializable {
	
	private String name;
	private String make;
	private String model;
	private double basePrice;
	private double totalPrice;
	private List<OptionSet.Option> choices;
	private List<OptionSet> optionSets;
	
	public Automobile() {
		this("", 0);
	}
	
	public Automobile(String name, double basePrice) {
		if (!name.equals("")) {
   		 String[] result = name.split(" ");
   	     make = result[0];
   	     model = result[1];
		} else {
   		make = "";
   		model ="";
		}
		this.name = name;
        this.basePrice = basePrice;
        optionSets = new ArrayList<OptionSet>();
        choices = new ArrayList<OptionSet.Option>();
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized String getMake() {
		return make;
	}

	public synchronized void setMake(String make) {
		this.make = make;
	}

	public synchronized String getModel() {
		return model;
	}

	public synchronized void setModel(String model) {
		this.model = model;
	}

	public synchronized double getBasePrice() {
		return basePrice;
	}

	public synchronized void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public synchronized List getOptionSets() {
		return optionSets;
	}
	
	public synchronized OptionSet getOptionSet(int i) {
		return optionSets.get(i);
	}
	
	public synchronized OptionSet.Option getOption(int i, int j) {
		return optionSets.get(i).getOptions(j);
	}

	public synchronized void setOptionSets(List optionSets) {
		this.optionSets = optionSets;
	}
	
	public synchronized OptionSet.Option getOptionChoice(String optionSetName) {
		return findOptionSet(optionSetName).getChoice();
	}
	
	public synchronized void setOptionChoice(String optionSetName, 
			String optionName) {
		if ((findOptionSet(optionSetName) != null) && 
				(findOptionSet(optionSetName).
				findOption(optionName) != null)) {
			findOptionSet(optionSetName).setChoice(optionName);
			int index = findOptionSetIndex(optionSetName);
			choices.set(index, getOptionChoice(optionSetName));
		}
	}
	
//	public void makeOptionSetsArray(int size) {
//		optionSets = new OptionSet[size];
//		for (int i = 0; i < size; i++)
//			optionSets[i] = new OptionSet();
//	}
	
	public synchronized void addOptionSet(String optionSetName) {
		optionSets.add(new OptionSet(optionSetName));
		choices.add(findOptionSet(optionSetName).new Option());
	}
	
	public synchronized void addOption(int i,
			String optionName, double price) {
		optionSets.get(i).addOption(optionName, price);
	}
	
	public synchronized int findOptionSetIndex(String optionSetName) {
		if (!isOptionSetsEmpty()) {
			for (int i = 0; i < optionSets.size(); i++) {
				if (optionSets.get(i) != null && 
						optionSets.get(i).getName().equals(optionSetName))
					return i;
			}
		}
		return -1;
	}
	
	public synchronized OptionSet findOptionSet(String optionSetName) {
		int index = findOptionSetIndex(optionSetName);
		return (index != -1) ? optionSets.get(index) : null;
	}
	
	public synchronized OptionSet.Option findOption(
			String optionSetName, String optionName) {
		if (findOptionSet(optionSetName) != null)
			return findOptionSet(optionSetName)
					.findOption(optionName);
		else 
			return null;
	}
	
	public synchronized void deleteOptionSet(String optionSetName) {
		int index = findOptionSetIndex(optionSetName);
		if (index != -1)
			optionSets.set(index, null);
	}
	
	public synchronized void deleteOption(
			String optionSetName, String optionName) {
		if (findOptionSet(optionSetName) != null)
			findOptionSet(optionSetName)
					.deleteOption(optionName);
	}
	
	public synchronized void updateOptionSet(String optionSetName,
			OptionSet newOptionSet) {
		int index = findOptionSetIndex(optionSetName);
		if (index != -1)
			optionSets.set(index, newOptionSet);
	}
	
	public synchronized void updateOption(String optionSetName, 
			String optionName, OptionSet.Option newOption) {
		if (findOptionSet(optionSetName) != null)
			findOptionSet(optionSetName)
					.updateOption(optionName, newOption);
	}
	
	public synchronized void updateOptionSetName(String optionSetName,
			String newOptionSetName) {
		int index = findOptionSetIndex(optionSetName);
		if (index != -1)
			optionSets.get(index).setName(newOptionSetName);
	}
	
	public synchronized void updateOptionName(String optionSetName,
			String optionName, String newOptionName) {
		int index = findOptionSetIndex(optionSetName);
		if (index != -1)
			optionSets.get(index).updateOptionName(
			optionName, newOptionName);
	}
	
	public synchronized void updateOptionPrice(String optionSetName,
			String optionName, double newPrice) {
		int index = findOptionSetIndex(optionSetName);
		if (index != -1)
			optionSets.get(index).updateOptionPrice(
			optionName, newPrice);
	}
	
	public synchronized boolean isOptionSetsEmpty() {
		return optionSets.isEmpty();
	}
	
	public synchronized boolean isOptionsNull(String optionSetName) {
		if (findOptionSet(optionSetName) != null)
			return findOptionSet(optionSetName).isOptionsEmpty();
		else
			return true;
	}
	
	public synchronized boolean areOptionSetsNull() {
        return optionSets == null;
    }
	
	public synchronized void print() {
        System.out.printf("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n%s\nBase price is $%.2f\n", name, basePrice);
        if (!areOptionSetsNull()) {
    		for(int i = 0; i < optionSets.size(); i++) {
            	if (optionSets.get(i) != null) optionSets.get(i).print();
            }	
    	}
        calculateTotalPrice();
        System.out.printf("\t\t~~Total price: $%.2f", totalPrice);
    }
	
	public synchronized void calculateTotalPrice() {
		totalPrice = basePrice;
		for (int i = 0; i < choices.size(); i++) {
			totalPrice += choices.get(i).getPrice();
		}
	}
	
	public synchronized void printChoices() {
		System.out.printf("Your Option Choices for %s:\n", name);
		for (int i = 0; i < choices.size(); i++) {
			choices.get(i).print();
		}
		calculateTotalPrice();
		System.out.printf("Total cost - $%.2f", totalPrice);
	}
	
}











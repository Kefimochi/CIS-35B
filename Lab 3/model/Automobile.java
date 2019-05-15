package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.*;
import model.OptionSet.Option;

public class Automobile implements Serializable {
    private String name; //full name
    private String make; //first
    private String model; //second
    private double basePrice;
    private ArrayList<OptionSet> opset;
    private List<OptionSet.Option> choices;

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
        opset = new ArrayList<OptionSet>();
    }

    public List<OptionSet.Option> getChoices() {
    	return choices;
    }
    
    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }
    
    public String getMake() {
    	return make;
    }
    
    public String getModel() {
    	return model;
    }
    
    public String getOptionChoice(String setName) {
    	return findOptionSet(setName).getOptionChoice().getName();
    }
    
    public double getOptionChoicePrice(String setName) { // <----------------
    	return findOptionSet(setName).getOptionChoice().getPrice();
    }
    
    public double getTotalPrice() { // <----------------
    	double totalPrice = basePrice;
    	if(!choices.equals(null)) {
    		for (int i = 0; i < choices.size(); i++) {
    			// Add every choice's prise to the base Price
    			totalPrice += getOptionChoicePrice(choices[i].getName);
    		}
    	}
    	return totalPrice;
    }

    public ArrayList<OptionSet> getOptionSets() {
        return opset;
    }
    
    public OptionSet.Option[] getOptions(int index) {
    		return getOptionSet(index).getOptions();
    }
    
    public OptionSet getOptionSet(int index) {
        return opset.get(index);
    }
    
    public OptionSet.Option getOption(int index, int optionIndex) {
    	return opset.get(index).getOptions()[optionIndex];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setOptionSets(ArrayList<OptionSet> opset) {
        this.opset = opset;
    }
    
    public void setOptionChoice(String setName, String optionName) {
    	findOptionSet(setName).setOptionChoice(optionName);
    }
    
    public void setChoices(List<OptionSet.Option> choices) {
    	this.choices = choices;
    }
    
    public void setMake(String make) {
    	this.make = make;
    }
    
    public void setModek(String model) {
    	this.model = model;
    }
  
    public void makeOptionSet(int index, String name,int size) {
    	opset.get(index).setName(name);
    	opset.get(index).makeOptionsArray(size);
    }
    
    public void makeOption(int i, int j,
			String optionName, double price) {
		if (!areOptionSetsNull()) {
			opset.get(i).makeOption(j, optionName, price);
		}
	}

    public int findOptionSetIndex(String name) {
    	if (!areOptionSetsNull()) {
        	for (int i = 0; i < opset.size(); i++) {
        		if (opset.get(i) != null && (opset.get(i).getName()).equals(name)) {
        			return i;
        		}
        	}
        }
    	return -1;
    }

    public OptionSet findOptionSet(String name) {
    	if (!areOptionSetsNull()) {
        	for (int i = 0; i < opset.size(); i++) {
        		if (opset.get(i) != null && (opset.get(i).getName()).equals(name))
        			return opset.get(i);
        	}
        }
    	return null;
    }
    
    public OptionSet.Option findOption(String opsetName, String optName) {
    	return findOptionSet(opsetName).findOption(optName);
    }

    public void deleteOptionSet(String name) { 
    	if (!areOptionSetsNull()) {
        	for (int i = 0; i < opset.size(); i++) {
        		if (opset.get(i) != null && (opset.get(i).getName()).equals(name))
        			opset.set(i, null);	
        	}
        }
    }

    public void deleteOption(String opsetName, String optName) {
    	if (!areOptionSetsNull()) {
        	for (int i = 0; i < opset.size(); i++) {
        		if (opset.get(i) != null && (opset.get(i).getName()).equals(name))
        			opset.get(i).updateOption(optName, null);	
        	}
        }
    }
    
    public void updateOptionSet(String name, OptionSet newOpset) {
    	if (!areOptionSetsNull()) {
        	for (int i = 0; i < opset.size(); i++) {
        		if (opset.get(i) != null && (opset.get(i).getName()).equals(name)) {
        			opset.set(i, newOpset);
        		}
        	}
        }
    }

    public void updateOptionSetName(String name, String newName) {
    	findOptionSet(name).setName(newName);
    }
    
    public void updateOption(String opsetName, String optName, OptionSet.Option newOpt) {
    	findOptionSet(opsetName).updateOption(optName, newOpt);
    }
    
    public void updateOptionName(String opsetName, String optName, String newName) { 
    	findOptionSet(opsetName).findOption(optName).setName(newName);
    }
    
    public void updateOptionPrice(String opsetName, String optName, double newPrice) {
    	findOptionSet(opsetName).updateOptionPrice(optName, newPrice);
    }    

    public boolean areOptionSetsNull() {
        return opset.equals(null);
    }
    
    public boolean areOptionsNull(int i) {
    	return (opset.get(i).getOptions()).equals(null);
    }

    public void print() {
        System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n%s\nBase price is $%.2f\n", name, basePrice);
        if (!areOptionSetsNull()) {
    		for(int i = 0; i < opset.size(); i++) {
            	if (opset.get(i) != null) opset.get(i).print();
            }	
    	}
    }
} 

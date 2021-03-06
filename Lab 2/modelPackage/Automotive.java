package modelPackage;
import java.io.Serializable;

import modelPackage.*;
import modelPackage.OptionSet.Option;

public class Automotive implements Serializable {
    private String name;
    private double basePrice;
    private OptionSet opset[];

    public Automotive() {
        
        basePrice = 0;
    }

    public Automotive(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public Automotive(String name, double basePrice, int size) {
        this.name = name;
        this.basePrice = basePrice;
        opset = new OptionSet[size];
        
        for (int i = 0; i < opset.length; i++) { // to avoid NPE
            opset[i] = new OptionSet();
        }
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public OptionSet[] getOptionSets() {
        return opset;
    }
    
    public OptionSet.Option[] getOptions(int index) {
//    	if (!isOptionsNull(index)) {
    		return getOptionSet(index).getOptions();
//    	}
//    	return null;
    }
    
    public OptionSet getOptionSet(int index) {
        return opset[index];
    }
    
    public OptionSet.Option getOption(int index, int optionIndex) {
    	return opset[index].getOptions()[optionIndex];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setOptionSets(OptionSet[] opset) {
        this.opset = opset;
    }
    
    public void makeOptionSetsArray(int size) {
    	opset = new OptionSet[size];
        for (int i = 0; i < opset.length; i++) {
            opset[i] = new OptionSet();
        }
    }
    
    public void makeOptionSet(int index, String name,int size) {
    	opset[index].setName(name);
    	opset[index].makeOptionsArray(size);
    }
    
    public void makeOption(int i, int j,
			String optionName, double price) {
		if (!isOptionSetsNull()) {
			opset[i].makeOption(j, optionName, price);
		}
	}

    public int findOptionSetIndex(String name) {
    	if (!isOptionSetsNull()) {
        	for (int i = 0; i < opset.length; i++) {
        		if (opset[i] != null && (opset[i].getName()).equals(name)) {
        			return i;
        		}
        	}
        }
    	return -1;
    }

    public OptionSet findOptionSet(String name) {
    	if (!isOptionSetsNull()) {
        	for (int i = 0; i < opset.length; i++) {
        		if (opset[i] != null && (opset[i].getName()).equals(name))
        			return opset[i];
        	}
        }
    	return null;
    }
    
    public OptionSet.Option findOption(String opsetName, String optName) {
    	return findOptionSet(opsetName).findOption(optName);
    }

    public void deleteOptionSet(String name) { 
    	if (!isOptionSetsNull()) {
        	for (int i = 0; i < opset.length; i++) {
        		if (opset[i] != null && (opset[i].getName()).equals(name))
        			opset[i] = null;	
        	}
        }
    }

    public void deleteOption(String opsetName, String optName) {
    	if (!isOptionSetsNull()) {
        	for (int i = 0; i < opset.length; i++) {
        		if (opset[i] != null && (opset[i].getName()).equals(name))
        			opset[i].updateOption(optName, null);	
        	}
        }
    }
    
    public void updateOptionSet(String name, OptionSet newOpset) {
    	if (!isOptionSetsNull()) {
        	for (int i = 0; i < opset.length; i++) {
        		if (opset[i] != null && (opset[i].getName()).equals(name)) {
        			opset[i] = newOpset;
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
    	findOptionSet(opsetName).findOption(optName).setPrice(newPrice);
    }    

    public boolean isOptionSetsNull() {
        return opset.equals(null);
    }
    
    public boolean isOptionsNull(int i) {
    	return (opset[i].getOptions()).equals(null);
    }

    public void print() {
        System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n%s\nBase price is $%.2f\n", name, basePrice);
        if (!isOptionSetsNull()) {
    		for(int i = 0; i < opset.length; i++) {
            	if (opset[i] != null) opset[i].print();
            }	
    	}
    }
}

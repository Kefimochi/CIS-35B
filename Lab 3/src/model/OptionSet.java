package model;

import java.io.Serializable;
import java.util.ArrayList;

public class OptionSet implements Serializable {
    private String name;
    private ArrayList<Option> opt;
    private Option choice;
    
    protected OptionSet() {
        this("");
    }

    protected OptionSet(String name) {
        this.name = name;
        opt = new ArrayList<Option>();
        choice = null;
    }

    protected String getName() {
        return name;
    }

    protected ArrayList<Option> getOptions() {
        return opt;
    }
    
    protected Option getOptionChoice() {
    	if (choice != null) return choice;
    	else return null;
    }
    
    protected void setOptionChoice(String choice) {
    	if (choice != null) this.choice = findOption(choice);
    	System.out.print("\nU MADE IT X4\n");
    	System.out.print("\n " + choice +"\n");
    	System.out.print("\n Got it?" + this.choice.getName() +"\n");
    	System.out.println("\nYOUR NEW OPTION CHOICE IS ");
    	this.choice.print();
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setOptions(ArrayList<Option> opt) {
        this.opt = opt;
    }
    
    protected void setChoice(String optionName) {
    	choice = findOption(optionName);
    }
    
    protected void addOption(String optionName, double price) {
		opt.add(new Option(optionName, price));
	}

    protected int findOptionIndex(String name) {
//        if (!isOptionNull()) {
        	for (int i = 0; i < opt.size(); i++) {
        		if ((opt.get(i).getName()).equals(name)) {
        	    	System.out.println("Hahahahha");
        			opt.get(i).print();
        			return i;
        		}
        	}
        	opt.get(0).print();
//        }
    	return -1;
    }

    protected Option findOption(String name) {
//    	if (!isOptionNull()) {
    	
//    		System.out.print("\nU MADE IT X5\n");
//    		System.out.print("\n" + name + " " + opt.size() + " " + "2\n");
//        	for (int i = 0; i < opt.size(); i++) {
//        		if ((opt.get(i).getName()).equals(name))
//        			return opt.get(i);
//        	}
//        }
//    	return null;
		System.out.print("\nU MADE IT X5\n");
		System.out.print("\n" + name + " " + opt.size() + " \n");
    	Option myOption = new Option();
    	int index = findOptionIndex(name);
    	myOption = (index != -1) ? opt.get(index) : null;
//    	System.out.print("Name" + myOption.getName());
    	return myOption;
    }

    protected void deleteOption(String name) {
    	int index = findOptionIndex(name);
        	if (index != -1) opt.set(index, null);
    }

    protected void updateOption(String name, Option newOpt) {
    	int index = findOptionIndex(name);
    	if (index != -1) opt.set(index, newOpt);
    }

    protected void updateOptionName(String name, String newName) {
    	int index = findOptionIndex(name);
    	if (index != -1) opt.get(index).setName(newName);
    }

    protected void updateOptionPrice(String name, double price) {
    	int index = findOptionIndex(name);
    	if (index != -1) opt.get(index).setPrice(price);
    }

    protected boolean isOptionNull() {
    	return opt == null;
    }

    protected void print() {
    	System.out.printf("*********%s*********\n", name);
    	if (!isOptionNull()) {
    		for(int i = 0; i < opt.size(); i++) {
            	if (opt.get(i) != null) opt.get(i).print();
            }	
    	}
    	if (choice != null)
    		System.out.printf("\n**Option choice: %s\n", choice.getName());
    }

    public class Option implements Serializable {
        private String optName;
        private double price;

        protected Option() {
            optName = "";
            price = 0;
        }

        protected Option(String optName, double price) {
            this.optName = optName;
            this.price = price;
        }

        protected String getName() {
            return optName;
        }

        protected double getPrice() {
            return price;
        }

        protected void setName(String optName) {
            this.optName = optName;
        }

        protected void setPrice(double price) {
            this.price = price;
        }
        
        protected void print() {
            System.out.printf("~ %s: $%.2f\n", optName, price);
        }
    }
}
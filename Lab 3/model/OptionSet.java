package model;

import java.io.Serializable;

public class OptionSet implements Serializable {
    private String name;
    private Option opt[];
    private Option choice;
    
    protected OptionSet() {
        name = "";
    }

    protected OptionSet(String name, int size) {
        this.name = name;
        opt = new Option[size];
        for (int i = 0; i < opt.length; i++) {
            opt[i] = new Option();
        }
    }

    protected String getName() {
        return name;
    }

    protected Option[] getOptions() {
        return opt;
    }
    
    protected Option getOptionChoice() {
    	if (!choice.equals(null)) return choice;
    	else return null;
    }
    
    protected void setOptionChoice(String choiceName) {
    	this.choice = findOption(choiceName);
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setOptions(Option[] opt) {
        this.opt = opt;
    }
    
    protected void makeOptionsArray(int size) {
    	opt = new Option[size];
    	for (int i = 0; i < opt.length; i++) {
            opt[i] = new Option();
        }
    }
    
    protected void makeOption(int j, String optionName, 
			double price) {
		if (!isOptionNull()) {
			opt[j].setName(optionName);
			opt[j].setPrice(price);
		}
	}

    protected int findOptionIndex(String name) {
        if (!isOptionNull()) {
        	for (int i = 0; i < opt.length; i++) {
        		if (opt[i] != null && (opt[i].getName()).equals(name)) {
        			return i;
        		}
        	}
        }
    	return -1;
    }

    protected Option findOption(String name) {
    	if (!isOptionNull()) {
        	for (int i = 0; i < opt.length; i++) {
        		if (opt[i] != null && (opt[i].getName()).equals(name))
        			return opt[i];
        	}
        }
    	return null;
    }

    protected void deleteOption(String name) {
    	if (!isOptionNull()) {
        	for (int i = 0; i < opt.length; i++) {
        		if (opt[i] != null && (opt[i].getName()).equals(name)) {
        			opt[i] = null;
        		}
        	}
        }
    }

    protected void updateOption(String name, Option newOpt) {
    	if (!isOptionNull()) {
        	for (int i = 0; i < opt.length; i++) {
        		if (opt[i] != null && (opt[i].getName()).equals(name)) {
        			opt[i] = newOpt;
        		}
        	}
        }
    }

    protected void updateOptionName(String name, String newName) {
    	if (!isOptionNull()) {
        	for (int i = 0; i < opt.length; i++) {
        		if (opt[i] != null && (opt[i].getName()).equals(name)) {
        			opt[i].setName(newName);
        		}
        	}
        }
    }

    protected void updateOptionPrice(String name, double price) { // <------------------------
    	if (!isOptionNull()) {
        	for (int i = 0; i < opt.length; i++) {
        		if (opt[i] != null && (opt[i].getName()).equals(name)) {
        			opt[i].setPrice(price);
        		}
        	}
        }
    }

    protected boolean isOptionNull() {
    	return opt == null;
    }

    protected void print() {
    	System.out.printf("*********%s*********\n", name);
    	if (!isOptionNull()) {
    		for(int i = 0; i < opt.length; i++) {
            	if (opt[i] != null) opt[i].print();
            }	
    	}
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
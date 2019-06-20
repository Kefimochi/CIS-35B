//	Prompts the user for available models.
//	a. Tip: Use Socket Class to interact with Server to find the available models.
//	2. Allows the user to select a model and enter its respective options.
//	3. Displays the selected options for a class.
package client;
import adapter.*;
import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SelectCarOptions {

	////////// PROPERTIES //////////
	private Scanner in = new Scanner(System.in);

	////////// CONSTRUCTORS //////////

	public SelectCarOptions() {

	}

	////////// INSTANCE METHODS //////////

	public void configureAuto(Object obj) {
//		public synchronized void setOptionChoice(String optionSetName, 
//				String optionName)
		String currentOptionSet = "";
		// For each optionset, the var will be updated and optionName will be asked
		
		BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
		Automobile auto = (Automobile) obj;
		String choice = "";
		
		 
	     
	     
		System.out.println("Let's start configuring the " + auto.getName());
		auto.print();

		for (int i = 0; i < auto.getOptionSets().size(); i++) {
			System.out.println("\nEnter a string representing your choice in " + auto.getOptionSetName(i));
			try {
				choice = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			auto.setOptionChoice(auto.getOptionSetName(i), choice);
			System.out.println("You chose " + auto.getOptionSetName(i) + " that costs: $" + auto.getOptionPrice(i));
		}
		
		
		System.out.println("\nConfiguration completed successfully.");
		auto.printChoices();
	}

	public boolean isAutomobile(Object obj) {
		boolean isAutomobile = false;

		try {
			Automobile a1 = (Automobile) obj;
			isAutomobile = true;
		}
		catch (ClassCastException e) {
			isAutomobile = false;
		}
		return isAutomobile;
	}

}

//	Prompts the user for available models.
//	a. Tip: Use Socket Class to interact with Server to find the available models.
//	2. Allows the user to select a model and enter its respective options.
//	3. Displays the selected options for a class.
package client;
import adapter.*;
import model.*;
import java.util.*;

public class SelectCarOptions {

	////////// PROPERTIES //////////
	private Scanner in = new Scanner(System.in);

	////////// CONSTRUCTORS //////////

	public SelectCarOptions() {

	}

	////////// INSTANCE METHODS //////////

	public void configureAuto(Object obj) {
//		public synchronized void chooseOption(String carName, String optionSetName,
//				String optionName) {
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

//	Add a class BuildCarModelOptions class, which has methods to do the following:
//		a. Accept properties object from client socket over an ObjectStream and create an
//		Automobile.
//		b. Then add that created Automobile to the LinkedHashMap. This method will be
//		declared in the AutoServer interface.
//		c. AutoServer interface should be implemented in BuildAuto and
//		BuildCarModelOptions classes.
//		d. Based on the current structure, this method will be implemented in
//		proxyAutomobile class and called in a method of BuildCarModelOptions.

package server;
import util.*;
import adapter.*;
import exception.ExceptionAuto;
import model.Automobile;

public class BuildCarModelOptions extends ProxyAutomobile {

	////////// PROPERTIES //////////

	private static final int WAITING = 0;
	private static final int REQUEST_BUILD_AUTO = 1;
	private static final int REQUEST_CONFIGURE_AUTO = 2;

	private int state = WAITING;

	////////// CONSTRUCTORS //////////

	public BuildCarModelOptions() {

	}

	////////// INSTANCE METHODS //////////

	public Object processRequest(Object obj) {
		Object toClient = null;

		if (state == REQUEST_BUILD_AUTO) {
		//add code to buildauto
			Automobile a1 = null;
			try {
				a1 = buildAuto(obj);
			} catch (ExceptionAuto e) {
				e.printStackTrace();
			}

			toClient = "Automobile object successfully added to database\n"
					+ "Press any key to return to main menu";
		}
		else if (state == REQUEST_CONFIGURE_AUTO) {
		//add code for configureauto
		}
		else {

		}

		this.state = WAITING;

		return toClient;
	}

	public String setRequest(int i) {
		String output = null;

		if (i == 1) {
			this.state = REQUEST_BUILD_AUTO;
			output = "Upload a file to create an Automobile";
		}
		else if (i == 2) {
			this.state = REQUEST_CONFIGURE_AUTO;
			output = "Select an Automobile from the following list to configure: \n";
					super.getAllModels();
		}
		else {
			output = "Invalid request";
		}

		return output;
	}



}

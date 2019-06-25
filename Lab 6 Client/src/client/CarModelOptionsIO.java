//	Read data from the Properties file; create properties object, using the load
//	method, which transfers the object from the client to server, using ObjectStream.
//	b. Receive a response from the Server, verifying that the Car Model object is
//	created successfully.
//	c. Use CreateAuto interface to build Automobile and handle different type of files,
//	passed in filetype.
	

package client;

import java.io.*;
import java.util.*;

public class CarModelOptionsIO {

	////////// PROPERTIES //////////


	////////// CONSTRUCTORS //////////

	public CarModelOptionsIO() {

	}

	////////// INSTANCE METHODS //////////

	public Object loadPropsFile(String fname) {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(fname));
		}
		catch (FileNotFoundException e) {
			System.err.println("Error in file directory ... ");
			System.exit(1);
		}
		catch (IOException e) {
			System.err.println("Error reading file from directory ... ");
			System.exit(1);
		}

		return props;
	}

	public Object loadTextFile(String fname) {
		StringBuffer sbuff = new StringBuffer();
		try {
			BufferedReader buff = new BufferedReader(new FileReader(fname));
			boolean eof = false;
			int counter = 0;
			while (!eof) {
				String line = buff.readLine();
				if (line == null)
					eof = true;
				else {
					if (counter == 0)
						sbuff.append(line);
					else
						sbuff.append("\n" + line);
				}
				counter++;
			}
			buff.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("Error in file directory ... ");
			System.exit(1);
		}
		catch (IOException e) {
			System.err.println("Error reading file from directory ... ");
			System.exit(1);
		}

		return sbuff;
	}

}

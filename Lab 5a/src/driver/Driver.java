package driver;

import java.util.LinkedHashMap;

import adapter.*;
import client.ClientInterface;
import client.DefaultSocketClient;
import exception.ExceptionAuto;
import model.*;
import util.FileIO;

public class Driver {

	public static void main(String[] args) {
		ClientInterface in = new DefaultSocketClient("localhost" , 4444);
		in.run();
	}
}
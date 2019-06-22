package driver;

import java.util.LinkedHashMap;

import adapter.*;
import exception.ExceptionAuto;
import model.*;
import util.FileIO;

public class Driver {

	public static void main(String[] args) {
		ServableAuto in = new BuildAuto();
		in.serve(4444);
	}

}
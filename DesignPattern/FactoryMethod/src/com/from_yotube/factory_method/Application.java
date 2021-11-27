package com.from_yotube.factory_method;

import com.from_yotube.factory_method.creator.Dialog;
import com.from_yotube.factory_method.creator.WebDialog;
import com.from_yotube.factory_method.creator.WindowsDialog;

public class Application {

	static Dialog dialog;
	private static final String OS_WINDOWS = "Windows";
	private static final String OS_HTML = "HTML";
	
	// The application picks a creator's type depending on the
    // current configuration or environment settings.
	public static void initialize() {
//		config = readApplicationConfigFile();
//	    if (config.OS == "Windows")
//	        dialog = new WindowsDialog();
//	    else if (config.OS == "Web")
//	        dialog = new WebDialog();
//	    else
//	        throw new Exception("Error! Unknown operating system.");
		
		String configOS = "Windows";
		if(OS_WINDOWS.equals(configOS)) {
			dialog = new WindowsDialog();
		}else if(OS_HTML.equals(configOS)) {
			dialog = new WebDialog();
		}else {
			System.out.println("Error! Unknown operating system.");
		}
	}
	
	// The client code works with an instance of a concrete
    // creator, albeit through its base interface. As long as
    // the client keeps working with the creator via the base
    // interface, you can pass it any creator's subclass.
	public static void main(String[] args) {
		initialize();
		dialog.render();
	}
}

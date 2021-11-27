package com.from_yotube.factory_method.creator;

import com.from_yotube.factory_method.product.ButtonProduct;
import com.from_yotube.factory_method.product.WindowsButton;

//Concrete creators override the factory method to change the
//resulting product's type.
public class WindowsDialog extends Dialog{

	@Override
	public ButtonProduct createButton() {
		return new WindowsButton();
	}

}

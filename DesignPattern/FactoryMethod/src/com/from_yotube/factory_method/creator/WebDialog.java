package com.from_yotube.factory_method.creator;

import com.from_yotube.factory_method.product.ButtonProduct;
import com.from_yotube.factory_method.product.HTMLButton;

public class WebDialog extends Dialog{

	@Override
	public ButtonProduct createButton() {
		return new HTMLButton();
	}

}

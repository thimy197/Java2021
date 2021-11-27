package com.from_yotube.factory_method.product;

//Concrete products provide various implementations of the
//product interface.
public class WindowsButton implements ButtonProduct{

	// Render a button in Windows style.
	@Override
	public void render() {
		System.out.println("Window button is rendered");
	}

	// Bind a native OS click event.
	@Override
	public void onClick() {
		System.out.println("Window: onClick event is created");
	}

}

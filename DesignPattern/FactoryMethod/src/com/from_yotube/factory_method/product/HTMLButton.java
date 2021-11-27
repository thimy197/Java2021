package com.from_yotube.factory_method.product;

public class HTMLButton implements ButtonProduct{

	// Return an HTML representation of a button.
	@Override
	public void render() {
		System.out.println("HTML button is rendered");
	}

	// Bind a web browser click event.
	@Override
	public void onClick() {
		System.out.println("HTML: onClick event is created");
	}

}

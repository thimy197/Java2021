package com.refactoring;

import com.refactoring.builders.CarBuilder;
import com.refactoring.builders.CarManualBuilder;
import com.refactoring.cars.Car;
import com.refactoring.cars.Manual;
import com.refactoring.directors.Director;

public class Demo {

	public static void main(String[] args) {

		Director director = new Director();

		/* SESSION: Car */
		// Director gets the concrete builder object from the client
		// (application code). That's because application knows better which
		// builder to use to get a specific product.
		CarBuilder builder = new CarBuilder();
		director.constructSportsCar(builder);
		// The final product is often retrieved from a builder object, since
		// Director is not aware and not dependent on concrete builders and
		// products.
		Car car = builder.getResult();
		System.out.println("CAR BUILT:\n" + car.getCarType());

		/* SESSION: Manual */
		CarManualBuilder manualBuilder = new CarManualBuilder();
		// Director may know several building recipes.
		director.constructSportsCar(manualBuilder);
		Manual carManual = manualBuilder.getResult();
		System.out.println("\nCAR MANUAL BUILT:\n" + carManual.print());

		/* Run Car */
		System.out.println("\nRUN:");
		car.getEngine().on();
		car.getTripComputer().showStatus();
		car.getEngine().go(1000);
		System.out.println(car.getEngine().getMileage() + " mileages");
		System.out.println("GPS at:"+ car.getGpsNavigator().getRoute());
	}

}

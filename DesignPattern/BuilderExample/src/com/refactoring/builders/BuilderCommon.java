package com.refactoring.builders;

import com.refactoring.cars.CarType;
import com.refactoring.components.Engine;
import com.refactoring.components.GPSNavigator;
import com.refactoring.components.Transmission;
import com.refactoring.components.TripComputer;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface BuilderCommon {
	
	void setCarType(CarType type);
	void setSeats(int seats);
	void setEngine(Engine engine);
	void setTransmission(Transmission transmission);
	void setTripComputer(TripComputer tripComputer);
	void setGPSNavigator(GPSNavigator gpsNavigator);
}

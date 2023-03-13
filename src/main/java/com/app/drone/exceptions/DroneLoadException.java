package com.app.drone.exceptions;

public class DroneLoadException extends RuntimeException
{
	public DroneLoadException(String drone_battary_low)
	{
		super(drone_battary_low);
	}
}

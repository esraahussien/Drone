package com.app.drone.entities;

import com.app.drone.model.DroneModel;
import com.app.drone.model.DroneState;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
public class Drone extends BaseEntity
{
	@Size(max = 100, message = "100 characters max")
	private String serialNumber;
	@Enumerated(EnumType.STRING)
	@Column()
	private DroneModel model;
	@Max(value = 500, message = "weight limit is : 500 gr")
	private double weight;
	@Enumerated(EnumType.STRING)
	@Column()
	private DroneState state;
	@Column()
	private double batteryCapacity;

	public String getSerialNumber()
	{
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber)
	{
		this.serialNumber = serialNumber;
	}

	public DroneModel getModel()
	{
		return model;
	}

	public void setModel(DroneModel model)
	{
		this.model = model;
	}

	public double getWeight()
	{
		return weight;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	public DroneState getState()
	{
		return state;
	}

	public void setState(DroneState state)
	{
		this.state = state;
	}

	public double getBatteryCapacity()
	{
		return batteryCapacity;
	}

	public void setBatteryCapacity(double batteryCapacity)
	{
		this.batteryCapacity = batteryCapacity;
	}

	public void updateBattaryLevel()
	{
		/*TODO:
		 * call service to get real battery level
		 * */
		setBatteryCapacity(Math.floor(Math.random() * 100));
	}
}

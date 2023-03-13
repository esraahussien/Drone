package com.app.drone.entities;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class DeliveryOrder extends BaseEntity
{
	@ManyToOne
	Drone drone;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "delivery_id")
	private List<Medication> medications;
	private LocalDateTime startTime;
	private boolean active;

	public DeliveryOrder(Drone drone, List<Medication> medications)
	{
		this.drone = drone;
		this.medications = medications;
		this.active = true;
	}

	public DeliveryOrder()
	{

	}

	public Drone getDrone()
	{
		return drone;
	}

	public void setDrone(Drone drone)
	{
		this.drone = drone;
	}

	public List<Medication> getMedications()
	{
		return medications;
	}

	public void setMedications(List<Medication> medications)
	{
		this.medications = medications;
	}

	public LocalDateTime getStartTime()
	{
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime)
	{
		this.startTime = startTime;
	}

	public boolean isActive()
	{
		return active;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}
}

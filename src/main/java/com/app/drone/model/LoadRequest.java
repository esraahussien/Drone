package com.app.drone.model;

import com.app.drone.entities.Medication;

import java.util.List;

public class LoadRequest
{
	private Integer droneId;
	private List<Medication> medicationList;

	public Integer getDroneId()
	{
		return droneId;
	}

	public void setDroneId(Integer droneId)
	{
		this.droneId = droneId;
	}

	public List<Medication> getMedicationList()
	{
		return medicationList;
	}

	public void setMedicationList(List<Medication> medicationList)
	{
		this.medicationList = medicationList;
	}
}

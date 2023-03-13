package com.app.drone.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class Medication extends BaseEntity
{
	@Column
	@Pattern(regexp = "^[A-Za-z0-9-_]*$", message = "Invalid Medication Name")
	private String name;
	@Column
	@Pattern(regexp = "^[A-Z0-9_]*$", message = "Invalid Medication Code")
	private String code;
	@Column
	private double weight;
	@Column
	@Lob
	private byte[] image;


	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public double getWeight()
	{
		return weight;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	public byte[] getImage()
	{
		return image;
	}

	public void setImage(byte[] image)
	{
		this.image = image;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}

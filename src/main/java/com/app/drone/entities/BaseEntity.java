package com.app.drone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@MappedSuperclass
public  class BaseEntity implements Persistable<Integer>
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Transient
	private boolean isNew = true;

	@Override
	@JsonIgnore
	public boolean isNew()
	{
		return isNew;
	}

	@PrePersist
	@PostLoad
	void markNotNew()
	{
		this.isNew = false;
	}

	@Override
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
}

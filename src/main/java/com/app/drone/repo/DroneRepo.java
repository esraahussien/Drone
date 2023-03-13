package com.app.drone.repo;

import com.app.drone.entities.Drone;
import com.app.drone.model.DroneState;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DroneRepo extends CrudRepository<Drone, Integer>
{
	List<Drone> findAllByStateEquals(DroneState state);
}

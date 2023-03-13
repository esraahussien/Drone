package com.app.drone.repo;



import com.app.drone.entities.DeliveryOrder;
import com.app.drone.entities.Drone;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryOrderRepo extends CrudRepository<DeliveryOrder, Integer>
{
	DeliveryOrder findByDroneAndActiveEquals(Drone drone, boolean isActive);
}

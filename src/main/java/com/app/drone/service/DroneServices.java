package com.app.drone.service;

import com.app.drone.entities.DeliveryOrder;
import com.app.drone.entities.Drone;
import com.app.drone.entities.Medication;
import com.app.drone.exceptions.DroneLoadException;
import com.app.drone.model.DroneState;
import com.app.drone.model.LoadRequest;
import com.app.drone.repo.DeliveryOrderRepo;
import com.app.drone.repo.DroneRepo;
import com.app.drone.repo.MedicationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DroneServices
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DroneServices.class);
	@Autowired
	DroneRepo droneRepo;
	@Autowired
	MedicationRepo medicationRepo;
	@Autowired
	DeliveryOrderRepo deliveryOrderRepo;

	public Drone registerDrone(Drone drone)
	{
		return droneRepo.save(drone);
	}

	public DeliveryOrder loadMedicationList(@Valid LoadRequest load)
	{
		Drone drone = droneRepo.findById(load.getDroneId()).get();
		if (drone.getBatteryCapacity() < 25)
			throw new DroneLoadException("Drone Battary Low");
		double totalLoadWeight = load.getMedicationList().stream().mapToDouble(Medication::getWeight).sum();
		if (totalLoadWeight > drone.getWeight())
			throw new DroneLoadException("over limited Weight");
		drone.setState(DroneState.LOADED);
		DeliveryOrder order = new DeliveryOrder(drone, load.getMedicationList());
		return deliveryOrderRepo.save(order);
	}

	public List<Drone> findAvilableDrones()
	{
		return droneRepo.findAllByStateEquals(DroneState.IDLE);
	}

	public List<Medication> checkLoadedMedication(Integer droneId)
	{
		Drone drone = droneRepo.findById(droneId).get();
		DeliveryOrder order = deliveryOrderRepo.findByDroneAndActiveEquals(drone, true);
		if (order != null)
			return order.getMedications();
		return new ArrayList<>();
	}

	public double getBattaryLevel(Integer droneId)
	{
		Drone drone = droneRepo.findById(droneId).get();
		return drone.getBatteryCapacity();
	}

	public void updateAndLogBatarryLevel()
	{
		List<Drone> droneList = (List<Drone>) droneRepo.findAll();
		droneList.forEach(e -> {
			e.updateBattaryLevel();
			LOGGER.info(LocalDateTime.now() + ":" + e.getSerialNumber() + " : " + e.getBatteryCapacity());
		});
		droneRepo.saveAll(droneList);
	}
}

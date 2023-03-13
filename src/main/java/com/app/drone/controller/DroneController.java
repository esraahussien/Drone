package com.app.drone.controller;

import com.app.drone.entities.DeliveryOrder;
import com.app.drone.entities.Drone;
import com.app.drone.entities.Medication;
import com.app.drone.model.LoadRequest;
import com.app.drone.service.DroneServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DroneController
{
	@Autowired
	DroneServices services;

	@PostMapping("/drone")
	public ResponseEntity<Drone> registerDrone(@Valid @RequestBody Drone drone)
	{
		Drone registeredDrone = services.registerDrone(drone);
		return new ResponseEntity<>(registeredDrone, HttpStatus.ACCEPTED);
	}

	@GetMapping("/drone")
	public ResponseEntity<List<Drone>> getDrone()
	{
		return new ResponseEntity<>(services.findAvilableDrones(), HttpStatus.ACCEPTED);
	}

	@PostMapping("/loadDrone")
	public ResponseEntity<DeliveryOrder> loadDrone(@Valid @RequestBody LoadRequest request)
	{
		DeliveryOrder deliveryOrder = services.loadMedicationList(request);

		return new ResponseEntity<>(deliveryOrder, HttpStatus.ACCEPTED);
	}

	@GetMapping("/drone/{drone_id}")
	public ResponseEntity<List<Medication>> getLoadedMedications(@PathVariable("drone_id") Integer droneId)
	{
		List<Medication> medications = services.checkLoadedMedication(droneId);
		return new ResponseEntity<>(medications, HttpStatus.ACCEPTED);
	}

	@GetMapping("/drone-battary/{drone_id}")
	public ResponseEntity<Double> getBattaryCapacity(@PathVariable("drone_id") Integer droneId)
	{
		double batteryLevel = services.getBattaryLevel(droneId);
		return new ResponseEntity<>(batteryLevel, HttpStatus.ACCEPTED);
	}
}

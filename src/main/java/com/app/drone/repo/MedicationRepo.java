package com.app.drone.repo;

import com.app.drone.entities.Medication;
import org.springframework.data.repository.CrudRepository;

public interface MedicationRepo extends CrudRepository<Medication,Integer>
{
}

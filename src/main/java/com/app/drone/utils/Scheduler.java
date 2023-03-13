package com.app.drone.utils;

import com.app.drone.service.DroneServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class Scheduler
{
	@Autowired
	DroneServices services;

	@Scheduled(fixedDelay = 120000)
	public void batteryLevelTask()
	{
		services.updateAndLogBatarryLevel();
	}

}

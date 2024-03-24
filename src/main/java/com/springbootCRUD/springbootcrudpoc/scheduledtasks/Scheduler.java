package com.springbootCRUD.springbootcrudpoc.scheduledtasks;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

	@Scheduled(fixedDelay = 2000)
	  private void scheduleWithFixedDelay() throws InterruptedException {
	      TimeUnit.SECONDS.sleep(5);
	      System.out.println("Scheduling at fixedDelay : " + LocalTime.now());
	  }
}

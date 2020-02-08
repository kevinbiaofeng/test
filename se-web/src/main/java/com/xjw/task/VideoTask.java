package com.xjw.task;

import org.springframework.scheduling.annotation.Scheduled;

public class VideoTask {
	
	@Scheduled(cron = "0 0/3 * * * ?")
	public void clickCount() {
		
	}
}

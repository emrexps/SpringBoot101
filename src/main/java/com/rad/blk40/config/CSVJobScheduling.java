package com.rad.blk40.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CSVJobScheduling {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	@Scheduled(cron = "0 */1 * * * *", zone = "Europe/Istanbul")
	public void perform() throws Exception {
		JobParameters params = new JobParametersBuilder()
				.addString("importUserJob", String.valueOf(System.currentTimeMillis())).toJobParameters();
		jobLauncher.run(job, params);
	}
}

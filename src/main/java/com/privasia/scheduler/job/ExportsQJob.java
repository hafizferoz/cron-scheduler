package com.privasia.scheduler.job;

import java.time.LocalDateTime;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import com.privasia.scheduler.config.ConfigureQuartz;
import com.privasia.scheduler.service.DeleteExportQService;
import com.privasia.scheduler.util.AppLogger;

/**
 * @author Hafiz Feroz
 *
 */
@Component
@DisallowConcurrentExecution
public class ExportsQJob implements Job {

	private static final AppLogger log = AppLogger.getInstance();	

	@Value("${cron.frequency.exportsqjob}")
	private String frequency;
	
	@Autowired
	private DeleteExportQService deleteExportQService;
	
	@Override
	public void execute(JobExecutionContext jobExecutionContext) {
		LocalDateTime today = LocalDateTime.now(); // Start date
		log.info("Running ExportsQJob | frequency: "+ today + " | "+ frequency );
		deleteExportQService.exeucte();
	}

	@Bean(name = "exportsQJobTrigger")
	public JobDetailFactoryBean sampleJob() {
		return ConfigureQuartz.createJobDetail(this.getClass());
	}

	@Bean(name = "exportsQJobTriggerBeanTrigger")
	public CronTriggerFactoryBean sampleJobTrigger(@Qualifier("exportsQJobTrigger") JobDetail jobDetail) {
		return ConfigureQuartz.createCronTrigger(jobDetail, frequency);
	}

}

package com.bharatonjava.batchLoader;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BatchMain {

	public static void main(String[] args)
			throws JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException, JobParametersInvalidException {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "batch-loader-spring-config.xml" });

		Job job = (Job) context.getBean("employeeLoaderJob");

		JobParameters jobParameters = new JobParameters();

		JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
		
		launcher.run(job, jobParameters);
		

	}

}

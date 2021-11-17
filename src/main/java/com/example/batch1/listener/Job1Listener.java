package com.example.batch1.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

@Slf4j
public class Job1Listener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
      log.info(jobExecution.getJobInstance().getJobName() + " start.");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info(jobExecution.getJobInstance().getJobName() + " end.");
    }
}

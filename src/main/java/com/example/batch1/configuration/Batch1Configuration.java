package com.example.batch1.configuration;

import com.example.batch1.listener.Job1Listener;
import com.example.batch1.step.Step1Processor;
import com.example.batch1.step.Step1Reader;
import com.example.batch1.step.Step1Writer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.kafka.KafkaItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class Batch1Configuration {
    @Autowired
    private Step1Reader reader;

    @Autowired
    private Step1Processor processor;

    @Autowired
    private Step1Writer writer;

    @Autowired
    JobBuilderFactory jobBuilder;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job batch1Job (@Qualifier("step1") Step step1) {
        return jobBuilder
                .get("batchJob")
                //.validator(new Validator()....)
                .incrementer(new RunIdIncrementer())
                //.listener(new Logging....())
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory
                .get("step1")
                .<String, String> chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(new Job1Listener())
                .build();
    }
}

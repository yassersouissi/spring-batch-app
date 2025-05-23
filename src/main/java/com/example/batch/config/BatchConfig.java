package com.example.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public Job helloJob(JobBuilderFactory jobBuilders, Step helloStep) {
        return jobBuilders.get("helloJob")
                .start(helloStep)
                .build();
    }

    @Bean
    public Step helloStep(StepBuilderFactory stepBuilders) {
        return stepBuilders.get("helloStep")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("=== Hello depuis Spring Batch ===");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}

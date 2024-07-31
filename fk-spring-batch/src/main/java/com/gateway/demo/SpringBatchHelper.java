package com.gateway.demo;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * SpringBatch助手
 *
 * <pre>
 *     简化SpringBatch处理操作
 * </pre>
 *
 * @author Allen.C.Y.Zhang
 * @since 2024-07-30
 */
@Component
public class SpringBatchHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringBatchHelper.applicationContext = applicationContext;
    }


    /* ------------------------------------------------------------ */
    // operation

    public static void launchJob(String jobName) throws JobInstanceAlreadyCompleteException,
            NoSuchJobException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        launchJob(jobName, new JobParameters());
    }

    public static void launchJob(String jobName, Map<String, Object> mapJobParameters) throws JobInstanceAlreadyCompleteException,
            NoSuchJobException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        JobParametersBuilder builder = new JobParametersBuilder();
        for (Map.Entry<String, Object> entry : mapJobParameters.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof String) {
                builder.addString(key, (String) value);
            } else if (value instanceof Long) {
                builder.addLong(key, (Long) value);
            } else if (value instanceof Double) {
                builder.addDouble(key, (Double) value);
            } else if (value instanceof Date) {
                builder.addDate(key, (Date) value);
            } else {
                throw new IllegalArgumentException("Unsupported spring batch job parameter type: " + value.getClass());
            }
        }

        launchJob(jobName, builder.toJobParameters());
    }

    public static void launchJob(String jobName, JobParameters jobParameters) throws JobInstanceAlreadyCompleteException,
            JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException, NoSuchJobException {
        JobLauncher jobLauncher = getJobLauncher();
        JobRegistry jobRegistry = getJobRegistry();

        jobLauncher.run(jobRegistry.getJob(jobName), jobParameters);
    }

    public static JobLauncher getJobLauncher() {
        return getBean(JobLauncher.class);
    }

    public static JobRegistry getJobRegistry() {
        return getBean(JobRegistry.class);
    }

    public static JobBuilderFactory getJobBuilderFactory() {
        return getBean(JobBuilderFactory.class);
    }

    public static StepBuilderFactory getStepBuilderFactory() {
        return getBean(StepBuilderFactory.class);
    }


    /* ------------------------------------------------------------ */
    // spring util

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }


    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }


    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }

}

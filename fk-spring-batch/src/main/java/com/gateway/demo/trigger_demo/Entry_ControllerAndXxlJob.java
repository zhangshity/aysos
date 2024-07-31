package com.gateway.demo.trigger_demo;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Slf4j
@RestController
@RequestMapping("/springbatch")
public class Entry_ControllerAndXxlJob {
    @Resource
    private JobLauncher jobLauncher;
    @Resource
    private ApplicationContext applicationContext;

    // Controller
    @GetMapping("/start")
    public String startJob(@RequestParam String jobName) {
        try {
            // 启动Spring Batch Job
            runSpringBatchJob(jobName);

            return "Job " + jobName + " started successfully";
        } catch (Exception e) {
            log.error("Job {} failed to start", jobName, e);
            return "Job " + jobName + " failed to start";
        }
    }

    // Scheduler
    @XxlJob("springBatchJob")
    public ReturnT<Object> triggerJob() {
        String xxlJobParam = XxlJobHelper.getJobParam();
        log.info("Job {} started successfully", xxlJobParam);
        try {
            // 启动Spring Batch Job
            runSpringBatchJob(xxlJobParam);

            log.info("Job {} started successfully", xxlJobParam);
            return new ReturnT<>("Job " + xxlJobParam + " started successfully");
        } catch (Exception e) {
            log.error("Job {} failed to start", xxlJobParam, e);
            return new ReturnT<>("Job " + xxlJobParam + " failed to start");
        }
    }






    private void runSpringBatchJob(String jobName) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        Job job =  applicationContext.getBean(jobName, Job.class);
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .addString("shit","asdasd啊哈哈哈哈哈哈哈")
                .toJobParameters();

        JobExecution jobExecution = jobLauncher.run(job, jobParameters);
        if (!jobExecution.getExitStatus().equals(ExitStatus.COMPLETED)) {
            throw new RuntimeException(String.format("%s Job execution failed.", jobName));
        }
    }












    @Slf4j
    @Configuration
    public static class XxlJobConfig {
        @Value("${xxl.job.admin.addresses}")
        private String adminAddresses;

        @Value("${xxl.job.executor.appname}")
        private String appName;

        @Value("${xxl.job.executor.ip}")
        private String ip;

        @Value("${xxl.job.executor.address}")
        private String address;

        @Value("${xxl.job.executor.port}")
        private int port;

        @Value("${xxl.job.accessToken}")
        private String accessToken;

        @Value("${xxl.job.executor.logpath}")
        private String logPath;

        @Value("${xxl.job.executor.logretentiondays}")
        private int logRetentionDays;

        @ConditionalOnProperty(prefix = "xxl.job", name = "enabled", havingValue = "true")
        @Bean
        public XxlJobSpringExecutor xxlJobExecutor() {
            log.info(">>>>>>>>>>> xxl-job config init.");
            XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
            xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
            xxlJobSpringExecutor.setAppname(appName);
            xxlJobSpringExecutor.setAddress(address);
            xxlJobSpringExecutor.setIp(ip);
            xxlJobSpringExecutor.setPort(port);
            xxlJobSpringExecutor.setAccessToken(accessToken);
            xxlJobSpringExecutor.setLogPath(logPath);
            xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);

            return xxlJobSpringExecutor;
        }
    }
}

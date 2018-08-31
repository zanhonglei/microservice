package com.xy.quartz.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Auther: zanhonglei
 * @Date: 2018/8/30 18:38
 * @Description:
 */
@DisallowConcurrentExecution
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            Thread.sleep(1000);
            System.out.println("执行同步任务");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.xy.quartz.job;

import org.quartz.*;

/**
 * @Auther: zanhonglei
 * @Date: 2019/1/28 09:44
 * @Description:
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class TestJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            Thread.sleep(2000);
            System.out.println("执行同步任务" + context.getTrigger().getJobDataMap().get("taskId"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

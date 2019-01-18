package com.xy.quartz.job;

import org.quartz.*;

/**
 * @Auther: zanhonglei
 * @Date: 2018/8/30 18:38
 * @Description:
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        System.out.println("getFireInstanceId" + context.getFireInstanceId().toString());
        System.out.println("getFireTime" + context.getFireTime().toString());
        System.out.println("getNextFireTime" + context.getNextFireTime().toString());
        System.out.println("getPreviousFireTime" + context.getPreviousFireTime().toString());

        try {
            int i = 0;
            do {
                i++;
                Thread.sleep(5000);
            System.out.println("执行同步任务10" + context.getTrigger().getJobDataMap().get("taskId"));
            } while (i != 3);

            System.out.println("执行同步任务3" + context.getTrigger().getJobDataMap().get("taskId"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

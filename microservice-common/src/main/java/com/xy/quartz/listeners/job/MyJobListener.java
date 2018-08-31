package com.xy.quartz.listeners.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * @Auther: zanhonglei
 * @Date: 2018/8/30 10:35
 * @Description: 创建自己的job Listener
 */
public class MyJobListener implements JobListener {

    public String getName() {
        String name = this.getClass().getName();
        System.out.println(name);
        return name;
    }

    public void jobToBeExecuted(JobExecutionContext context) {

    }

    public void jobExecutionVetoed(JobExecutionContext context) {

    }

    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {

    }
}

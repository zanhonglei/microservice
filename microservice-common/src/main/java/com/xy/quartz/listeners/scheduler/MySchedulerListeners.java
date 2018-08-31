package com.xy.quartz.listeners.scheduler;

import org.quartz.*;

/**
 * @Auther: zanhonglei
 * @Date: 2018/8/30 10:51
 * @Description: 添加job/触发器，删除job/触发器，调度程序中的严重错误，关闭调度程序的通知等。
 */
public class MySchedulerListeners implements SchedulerListener {

    public void jobScheduled(Trigger trigger) {

    }

    public void jobUnscheduled(TriggerKey triggerKey) {

    }

    public void triggerFinalized(Trigger trigger) {

    }

    public void triggerPaused(TriggerKey triggerKey) {

    }

    public void triggersPaused(String triggerGroup) {

    }

    public void triggerResumed(TriggerKey triggerKey) {

    }

    public void triggersResumed(String triggerGroup) {

    }

    public void jobAdded(JobDetail jobDetail) {

    }

    public void jobDeleted(JobKey jobKey) {

    }

    public void jobPaused(JobKey jobKey) {

    }

    public void jobsPaused(String jobGroup) {

    }

    public void jobResumed(JobKey jobKey) {

    }

    public void jobsResumed(String jobGroup) {

    }

    public void schedulerError(String msg, SchedulerException cause) {

    }

    public void schedulerInStandbyMode() {

    }

    public void schedulerStarted() {

    }

    public void schedulerStarting() {

    }

    public void schedulerShutdown() {

    }

    public void schedulerShuttingdown() {

    }

    public void schedulingDataCleared() {

    }
}

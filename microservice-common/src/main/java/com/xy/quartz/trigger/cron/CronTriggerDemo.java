package com.xy.quartz.trigger.cron;

import com.xy.quartz.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Auther: zanhonglei
 * @Date: 2018/8/30 11:08
 * @Description:
 */
public class CronTriggerDemo {
    public static void main(String[] args) throws SchedulerException {
        //可以创建自己的JobFactory实现，比如让你的IOC或DI容器可以创建/初始化job实例。
        Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
//        SchedulerFactory sf = new StdSchedulerFactory();
//        ((StdSchedulerFactory) sf).initialize();

        //sched.getListenerManager().addJobListener(new MyJobListener(),jobGroupEquals("group1"));

        //sched.getListenerManager().addTriggerListener(new MyTriggerListener(),triggerGroupEquals("group1"));

        //sched.getListenerManager().addSchedulerListener(new MySchedulerListeners());

        JobDetail jobDetail = newJob(HelloJob.class)
                .withIdentity("myJob", "group1") // name "myJob", group "group1"
                .usingJobData("hello", "hello word")
                .build();


        // 基于表达式构建触发器
        //CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(formatCornExpression(cycle,cycleContent,cycleBeginTime));
        // CronTrigger表达式触发器 继承于Trigger
        // TriggerBuilder 用于构建触发器实例
       /* CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startAt(cycleBeginTime)
                .withSchedule(cronScheduleBuilder)
                .build();*/


        // Trigger the job to run now, and then every 2 seconds
        Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(cronSchedule("0/3 * * * * ?")) //
                .build();

        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(jobDetail, trigger);

        sched.start();

        //sched.shutdown();
    }
}

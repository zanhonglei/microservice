package com.xy.quartz.trigger.simple;

import com.xy.quartz.job.HelloJob;
import com.xy.quartz.listeners.job.MyJobListener;
import com.xy.quartz.listeners.scheduler.MySchedulerListeners;
import com.xy.quartz.listeners.trigger.MyTriggerListener;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.impl.matchers.GroupMatcher.jobGroupEquals;
import static org.quartz.impl.matchers.GroupMatcher.triggerGroupEquals;

/**
 * @Auther: zanhonglei
 * @Date: 2018/8/30 10:21
 * @Description:
 */
public class SimpleTriggerDemo {
    public static void main(String[] args) throws SchedulerException {
        //可以创建自己的JobFactory实现，比如让你的IOC或DI容器可以创建/初始化job实例。
        Scheduler sched = StdSchedulerFactory.getDefaultScheduler();

        sched.getListenerManager().addJobListener(new MyJobListener(),jobGroupEquals("group1"));

        sched.getListenerManager().addTriggerListener(new MyTriggerListener(),triggerGroupEquals("group1"));

        sched.getListenerManager().addSchedulerListener(new MySchedulerListeners());

        JobDetail jobDetail = newJob(HelloJob.class)
                .withIdentity("myJob", "group1") // name "myJob", group "group1"
                .usingJobData("hello", "hello word")
                .build();




        // Trigger the job to run now, and then every 2 seconds
        Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(1).repeatForever()) // 每秒
                //.withSchedule(simpleSchedule().withIntervalInMinutes(1).repeatForever()) //每分钟
                //.withSchedule(simpleSchedule().withIntervalInHours(2).repeatForever()) //每小时
                //.withSchedule(simpleSchedule().withIntervalInHours(24 * 8).repeatForever()) //每天
                .build();


        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(jobDetail, trigger);

        sched.start();
    }

}

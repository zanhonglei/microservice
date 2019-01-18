package com.xy.controller;

import com.xy.quartz.core.QuartzScheduler;
import com.xy.quartz.job.MyJob;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther: zanhonglei
 * @Date: 2018/8/31 09:26
 * @Description:
 */
@RestController
public class QuartzController {

    @Autowired
    QuartzScheduler quartzScheduler;

    @GetMapping("/start1")
    public String start1() {
        try {
            //需要注意的是 此处刚执行job，不要马上回去job信息，因为job会在调度器中初始化，创建执行任务周期，如果马上回去job信息可能会NPE
            quartzScheduler.startJob("123",new Date(),"4","1",MyJob.class);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "start1";
    }
    @GetMapping("/start2")
    public String start2() {
        try {
            quartzScheduler.startJob("123123",new Date(),"4","2",MyJob.class);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "start2";
    }
    @GetMapping("/pause")
    public String pause() {
        try {
            quartzScheduler.pauseJob("123");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        try {
            return quartzScheduler.getJobInfo("123");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "error";
    }
    @GetMapping("/resume")
    public String resume(String key) {
        try {
            quartzScheduler.resumeJob(key);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        try {
            return quartzScheduler.getJobInfo(key);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "error";
    }

}

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

    @GetMapping("/start")
    public String start() {
        try {
            quartzScheduler.startJob("123",new Date(),"3","1",MyJob.class);
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

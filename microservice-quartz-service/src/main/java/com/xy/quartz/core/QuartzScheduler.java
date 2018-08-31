package com.xy.quartz.core;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * 任务调度处理
 * @author
 *
 */
@Component
public class QuartzScheduler {
    //分组 默认使用ums7.0 创建的任务都在一个组里
    private static final String GROUP = "ums7.0";

    // 任务调度
    @Autowired
    private Scheduler scheduler;


    /**
     * 开始执行任务
     * @param taskId 同步任务Id
     * @param cycleBeginTime 周期开始时间
     * @param cycle 任务周期类型
     *              1：星期， 1-7  1是星期一 7是星期日
     *              2：天
     *              3：分钟
     * @param cycleContent 任务周期间隔设置
     * @param job 需要实现或者集成Job接口的任务
     * @throws SchedulerException
     */
    public void startJob(String taskId,Date cycleBeginTime, String cycle,String cycleContent ,Class<? extends Job> job) throws SchedulerException {
        // 通过JobBuilder构建JobDetail实例，JobDetail规定只能是实现Job接口的实例
        // JobDetail 是具体Job实例
        JobDetail jobDetail = JobBuilder.newJob(job).withIdentity(taskId, GROUP).build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity(taskId, GROUP)
                .withSchedule(initSchedule(cycle,cycleContent))
                .startAt(cycleBeginTime)
                .build();

        scheduler.scheduleJob(jobDetail, trigger);

        scheduler.start();
    }

    /**
     * 获取Job信息
     * @param taskId taskId 同步任务id
     * @return
     * @throws SchedulerException
     */
    public String getJobInfo(String taskId) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(taskId, GROUP);
        Trigger trigger = scheduler.getTrigger(triggerKey);
        return trigger.getDescription() + scheduler.getTriggerState(triggerKey).name();
    }

    /**
     * 修改某个任务的执行时间
     * @param taskId 任务id
     * @param cycleBeginTime 周期开始时间
     * @param cycle 周期类型
     * @param cycleContent 周期间隔
     * @return
     * @throws SchedulerException
     */
    public boolean modifyJob(String taskId,Date cycleBeginTime, String cycle,String cycleContent ) throws SchedulerException {
        Date date = null;
        TriggerKey triggerKey = new TriggerKey(taskId, GROUP);
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity(taskId, GROUP)
                .withSchedule(initSchedule(cycle,cycleContent))
                .startAt(cycleBeginTime)
                .build();
        date = scheduler.rescheduleJob(triggerKey, trigger);
        return date != null;
    }

    /**
     * 暂停所有任务
     * @throws SchedulerException
     */
    public void pauseAllJob() throws SchedulerException {
        scheduler.pauseAll();
    }

    /**
     * 暂停某个任务
     * @param taskId 同步任务id
     * @throws SchedulerException
     */
    public void pauseJob(String taskId) throws SchedulerException {
        JobKey jobKey = new JobKey(taskId, GROUP);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null)
            return;
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复所有任务
     * @throws SchedulerException
     */
    public void resumeAllJob() throws SchedulerException {
        scheduler.resumeAll();
    }

    /**
     * 恢复某个任务
     * @param taskId 同步任务id
     * @throws SchedulerException
     */
    public void resumeJob(String taskId) throws SchedulerException {
        JobKey jobKey = new JobKey(taskId, GROUP);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null)
            return;
        scheduler.resumeJob(jobKey);
    }

    /**
     * 删除某个任务
     * @param taskId 同步任务id
     * @throws SchedulerException
     */
    public void deleteJob(String taskId) throws SchedulerException {
        JobKey jobKey = new JobKey(taskId, GROUP);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null)
            return;
        scheduler.deleteJob(jobKey);
    }
    /**
     * 初始化调度器(周期间隔)
     * @param cycle 任务周期类型
     *              1：星期， 1-7  1是星期一 7是星期日
     *              2：天
     *              3：分钟
     * @param cycleContent 周期间隔
     * @return cron表达式
     */
    private ScheduleBuilder initSchedule(String cycle, String cycleContent ){
        SimpleScheduleBuilder sm = SimpleScheduleBuilder.simpleSchedule();
        switch (cycle) {
            case "1": //星期
                CalendarIntervalScheduleBuilder cb = CalendarIntervalScheduleBuilder.calendarIntervalSchedule();
                String[] weeks = cycleContent.split(",");
                for (String week : weeks) {
                    cb.withIntervalInWeeks(formatWeeks(week));
                }
                return cb;
            case "2": // 天
                sm.withIntervalInMinutes(Integer.valueOf(cycleContent) * 24);
                break;
            case "3": //分钟
                sm.withIntervalInMinutes(Integer.valueOf(cycleContent));
                break;
        }
        return sm.repeatForever();
    }

    /**
     * 格式化星期
     *
     *     输入：  1-7  1星期一，2星期二，3星期三，4星期四，5星期五，6星期六，7星期日
     *     输出：  1-7  1星期日，2星期一，3星期二，4星期三，5星期四，6星期五，7星期六
     * @param week
     * @return
     */
    private int formatWeeks(String week){
        //输入加1 2-8  2星期一，3星期二，4星期三，5星期四，6星期五，7星期六，8星期日
        Integer weekInt = Integer.valueOf(week) - 1;
        if (weekInt.equals(8)) {
            return 1;
        } else {
            return weekInt;
        }
    }

}
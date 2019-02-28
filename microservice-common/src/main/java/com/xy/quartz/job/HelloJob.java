package com.xy.quartz.job;
import org.quartz.*;

/**
 * @Auther: zanhonglei
 * @Date: 2018/8/29 19:12
 * @Description:
 */
@DisallowConcurrentExecution //告诉Quartz不要并发地执行同一个job定义（这里指特定的job类）的多个实例
@PersistJobDataAfterExecution
public class HelloJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            Thread.sleep(1000);
            System.out.println("job run");
            JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();

            /***********注意区分**************/
            // context.getJobDetail().getJobDataMap();
            // context.getTrigger().getJobDataMap();
            // context.getMergedJobDataMap();


            System.out.println(jobDataMap.get("hello").toString());
        } catch (Exception e) {
            throw new JobExecutionException();
        }
    }
}

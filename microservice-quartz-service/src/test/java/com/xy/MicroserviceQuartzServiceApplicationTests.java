package com.xy;

import com.xy.quartz.core.QuartzScheduler;
import com.xy.quartz.job.MyJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroserviceQuartzServiceApplicationTests {

    @Autowired
    private QuartzScheduler quartzScheduler;

    @Test
    public void contextLoads() throws SchedulerException {
        quartzScheduler.startJob("123",new Date(),"1","2",MyJob.class);
    }

}

package com.xy.quartz.listeners.trigger;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/**
 * @Auther: zanhonglei
 * @Date: 2018/8/30 10:35
 * @Description: 创建自己的 Trigger Listener
 */
public class MyTriggerListener implements TriggerListener {

    public String getName() {
        String name = this.getClass().getName();
        System.out.println(name);
        return name;
    }

    public void triggerFired(Trigger trigger, JobExecutionContext context) {

    }

    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        return false;
    }

    public void triggerMisfired(Trigger trigger) {

    }

    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {

    }
}

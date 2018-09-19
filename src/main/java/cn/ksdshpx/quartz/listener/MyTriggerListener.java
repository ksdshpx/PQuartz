package cn.ksdshpx.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/19
 * Time: 14:23
 * Description:TriggerListener
 */
public class MyTriggerListener implements TriggerListener {
    @Override
    public String getName() {
        String name = this.getClass().getSimpleName();
        System.out.println("触发器的名称:" + name);
        return name;
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext jobExecutionContext) {
        String name = trigger.getKey().getName();
        System.out.println("触发器:" + name + "即将被触发时执行！");
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext jobExecutionContext) {
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        String name = trigger.getKey().getName();
        System.out.println("触发器:" + name + "错过触发时执行！");
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext,
                                Trigger.CompletedExecutionInstruction completedExecutionInstruction) {
        String name = trigger.getKey().getName();
        System.out.println("触发器:" + name + "触发完成时执行！");
    }
}

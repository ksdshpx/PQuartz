package cn.ksdshpx.quartz.listener;

import org.quartz.*;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/19
 * Time: 15:20
 * Description:自定义SchedulerListener
 */
public class MySchedulerListener implements SchedulerListener{
    @Override
    public void jobScheduled(Trigger trigger) {
        String name = trigger.getKey().getName();
        System.out.println("JobDetail完成部署时调用！");
    }

    @Override
    public void jobUnscheduled(TriggerKey triggerKey) {
        System.out.println("JobDetail被卸载时调用！");
    }

    @Override
    public void triggerFinalized(Trigger trigger) {

    }

    @Override
    public void triggerPaused(TriggerKey triggerKey) {

    }

    @Override
    public void triggersPaused(String s) {

    }

    @Override
    public void triggerResumed(TriggerKey triggerKey) {

    }

    @Override
    public void triggersResumed(String s) {

    }

    @Override
    public void jobAdded(JobDetail jobDetail) {

    }

    @Override
    public void jobDeleted(JobKey jobKey) {

    }

    @Override
    public void jobPaused(JobKey jobKey) {

    }

    @Override
    public void jobsPaused(String s) {

    }

    @Override
    public void jobResumed(JobKey jobKey) {

    }

    @Override
    public void jobsResumed(String s) {

    }

    @Override
    public void schedulerError(String s, SchedulerException e) {

    }

    @Override
    public void schedulerInStandbyMode() {

    }

    @Override
    public void schedulerStarted() {

    }

    @Override
    public void schedulerStarting() {

    }

    @Override
    public void schedulerShutdown() {

    }

    @Override
    public void schedulerShuttingdown() {

    }

    @Override
    public void schedulingDataCleared() {

    }
}

package cn.ksdshpx.quartz.main;

import cn.ksdshpx.quartz.job.MyListenerJob;
import cn.ksdshpx.quartz.listener.MyTriggerListener;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/14
 * Time: 11:08
 * Description:测试程序
 */
public class QuartzTriggerListenerTest {
    public static void main(String[] args) throws Exception {
        //调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //任务
        JobDetail jobDetail = JobBuilder.newJob(MyListenerJob.class)
                .withIdentity("job1", "group1")
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
        //创建并注册一个全局的TriggerListener
        //scheduler.getListenerManager().addTriggerListener(new MyTriggerListener(), EverythingMatcher.allTriggers());
        //创建并注册一个局部的riggerListener
        scheduler.getListenerManager().addTriggerListener(new MyTriggerListener(),
                KeyMatcher.keyEquals(TriggerKey.triggerKey("trigger1", "group1")));
        scheduler.start();
    }
}

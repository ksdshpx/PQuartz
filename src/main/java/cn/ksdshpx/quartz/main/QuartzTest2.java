package cn.ksdshpx.quartz.main;

import cn.ksdshpx.quartz.job.MyTriggerJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/14
 * Time: 11:08
 * Description:测试程序
 */
public class QuartzTest2 {
    public static void main(String[] args) throws Exception {
        //调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //任务
        JobDetail jobDetail = JobBuilder.newJob(MyTriggerJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("message", "haha")
                .usingJobData("count", 0)
                .build();
        //触发器开始触发的时间
        Date startDate = new Date();
        startDate.setTime(startDate.getTime() + 3000);
        //触发器结束触发的时间
        Date endDate = new Date();
        endDate.setTime(endDate.getTime() + 10000);
        //触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .startAt(startDate)
                .endAt(endDate)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}

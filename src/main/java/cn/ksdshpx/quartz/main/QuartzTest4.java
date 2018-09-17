package cn.ksdshpx.quartz.main;

import cn.ksdshpx.quartz.job.MyCronTriggerJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/14
 * Time: 11:08
 * Description:测试程序
 */
public class QuartzTest4 {
    public static void main(String[] args) throws Exception {
        //调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //任务
        JobDetail jobDetail = JobBuilder.newJob(MyCronTriggerJob.class)
                .withIdentity("job1", "group1")
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}

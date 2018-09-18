package cn.ksdshpx.quartz.main;

import cn.ksdshpx.quartz.job.MyListenerJob;
import cn.ksdshpx.quartz.listener.MyJobListener;
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
public class QuartzJobListenerTest {
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
        //创建并注册一个全局的Job Listener
        //scheduler.getListenerManager().addJobListener(new MyJobListener(), EverythingMatcher.allJobs());
        //创建并注册一个局部的监听器
        scheduler.getListenerManager().addJobListener(new MyJobListener(), KeyMatcher.keyEquals(JobKey.jobKey("job2", "group1")));
        scheduler.start();
    }
}

package cn.ksdshpx.quartz.job;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/14
 * Time: 10:30
 * Description:定义任务类
 */
public class MyTriggerJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //执行任务
        System.out.println("正在执行数据库的备份,备份数据库的时间是:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Trigger trigger = jobExecutionContext.getTrigger();
        JobKey jobKey = trigger.getJobKey();
        System.out.println("jobKeyName:" + jobKey.getName() + ",jobKeyGroup:" + jobKey.getGroup());
        System.out.println("triggerStartDate:" + trigger.getStartTime() + ",triggerEndDate:" + trigger.getEndTime());
    }
}

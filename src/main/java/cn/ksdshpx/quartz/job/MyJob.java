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
public class MyJob implements Job {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public MyJob() {
        System.out.println("欢迎访问Myjob!");
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println("工作任务名称:" + jobKey.getName() + ",工作任务组:" + jobKey.getGroup());
        System.out.println("任务名称(带路径):" + jobExecutionContext.getJobDetail().getJobClass().getName());
        System.out.println("任务名称:" + jobExecutionContext.getJobDetail().getJobClass().getSimpleName());
        System.out.println("==============");
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println(jobDataMap.getString("JobDetailMsg"));
        JobDataMap triggerDataMap = jobExecutionContext.getTrigger().getJobDataMap();
        System.out.println(triggerDataMap.getString("TriggerMsg"));
        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        System.out.println("触发器名称:" + triggerKey.getName() + ",触发器组:" + triggerKey.getGroup());
        System.out.println("message:" + message);
        //执行任务
        System.out.println("正在执行数据库的备份,备份数据库的时间是:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}

package cn.ksdshpx.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

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
    public MyJob(){
        System.out.println("欢迎访问Myjob!");
    }
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //执行任务
        System.out.println("正在执行数据库的备份,备份数据库的时间是:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}

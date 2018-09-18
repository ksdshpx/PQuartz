package cn.ksdshpx.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/18
 * Time: 15:58
 * Description:自定义JobListener
 */
public class MyJobListener implements JobListener {
    @Override
    public String getName() {
        String name = this.getClass().getSimpleName();
        System.out.println("监听器的名称是:" + name);
        return name;
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        String name = jobExecutionContext.getJobDetail().getKey().getName();
        System.out.println("job的名称是:" + name + "Scheduler在JobDetail将要被执行的时候调用的方法！");
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        String name = jobExecutionContext.getJobDetail().getKey().getName();
        System.out.println("job的名称是:" + name + "Scheduler在JobDetail将要被执行,但又被TriggerListener否决时会调用该方法！");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        String name = jobExecutionContext.getJobDetail().getKey().getName();
        System.out.println("job的名称是:" + name + "Scheduler在JobDetail被执行之后调用该方法！");
    }
}

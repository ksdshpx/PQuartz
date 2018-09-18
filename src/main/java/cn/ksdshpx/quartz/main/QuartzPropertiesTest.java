package cn.ksdshpx.quartz.main;

import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Properties;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/18
 * Time: 13:49
 * Description:使用代码操作quartz.properties
 */
public class QuartzPropertiesTest {
    public static void main(String[] args) {
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Properties props = new Properties();
        try {
            props.put(StdSchedulerFactory.PROP_THREAD_POOL_CLASS,"org.quartz.simpl.SimpleThreadPool");
            props.put("org.quartz.threadPool.threadCount","5");
            stdSchedulerFactory.initialize(props);
            Scheduler scheduler = stdSchedulerFactory.getScheduler();
            scheduler.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

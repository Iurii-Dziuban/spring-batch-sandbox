package main.scheduler;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dziubani on 4/11/2016.
 */

public class SpringBatchSchedulerTest {

    public static void main( String[] args ) throws Exception {
        new ClassPathXmlApplicationContext(new String[]{"classpath:scheduler/application-context.xml"});
    }
}

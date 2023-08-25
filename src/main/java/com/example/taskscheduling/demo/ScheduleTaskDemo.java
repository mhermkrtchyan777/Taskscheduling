package com.example.taskscheduling.demo;

import com.example.taskscheduling.config.DataServiceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class ScheduleTaskDemo {
    public static void main(String[] args) throws Exception {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(DataServiceConfig.class);
        System.in.read();
        ctx.close();
    }
}

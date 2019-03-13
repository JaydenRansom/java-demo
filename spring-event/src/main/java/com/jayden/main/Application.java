package com.jayden.main;

import com.jayden.event.NewEventSource;
import com.jayden.event.TestEventSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 测试主类
 * @author jayden
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("application-context.xml");
        TestEventSource source = (TestEventSource) context.getBean("testEventSource");
        NewEventSource source0 = (NewEventSource) context.getBean("newEventSource");
        source.publishEvent("test msg");
        source0.publishEvent("new msg");
    }
}

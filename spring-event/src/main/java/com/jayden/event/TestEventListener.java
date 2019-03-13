package com.jayden.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听者
 *
 * @author jayden
 */
@Component
public class TestEventListener implements ApplicationListener<TestEvent> {

    private static final Logger logger = LoggerFactory.getLogger(TestEventListener.class);

    @Override
    public void onApplicationEvent(TestEvent event) {
        logger.info("publish event, msg is: {}", event.getMsg());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("publish and sleep over.");
    }
}

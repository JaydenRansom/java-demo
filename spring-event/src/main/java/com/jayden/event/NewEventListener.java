package com.jayden.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author jayden
 */
@Component
public class NewEventListener implements ApplicationListener<NewEvent> {

    private static final Logger logger = LoggerFactory.getLogger(NewEventListener.class);

    @Override
    public void onApplicationEvent(NewEvent event) {
        logger.info("publish new event, msg is: {}", event.getMsg());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("publish and sleep over.");
    }
}
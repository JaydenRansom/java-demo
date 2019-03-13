package com.jayden.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 事件源
 * @author jayden
 */
@Component
public class NewEventSource implements ApplicationEventPublisherAware {

    private static final Logger logger = LoggerFactory.getLogger(NewEventSource.class);

    private ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent(String msg) {
        logger.info("msg is: {}", msg);
        //Spring进行事件的通知, 无需自行处理
        applicationEventPublisher.publishEvent(new TestEvent(this, msg));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}

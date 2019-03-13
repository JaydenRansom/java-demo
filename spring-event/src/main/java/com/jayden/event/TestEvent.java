package com.jayden.event;

import org.springframework.context.ApplicationEvent;

/**
 * 事件对象定义
 *
 * @author jayden
 */
public class TestEvent extends ApplicationEvent {

    /**
     * 自定义消息字段
     */
    private String msg;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public TestEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}

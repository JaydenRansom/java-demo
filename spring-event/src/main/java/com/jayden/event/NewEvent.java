package com.jayden.event;

import org.springframework.context.ApplicationEvent;

/**
 * 事件对象定义
 * @author jayden
 */
public class NewEvent extends ApplicationEvent {

    private String msg;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public NewEvent(Object source, String msg) {
        super(source);
        this.msg = "new-event-" + msg;
    }

    public String getMsg() {
        return msg;
    }
}

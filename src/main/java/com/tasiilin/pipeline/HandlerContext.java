package com.tasiilin.pipeline;

public class HandlerContext {

    HandlerContext next;
    AbstractHandler handler;
    long preProcessingTime;

    public HandlerContext(AbstractHandler handler) {
        this.handler = handler;
    }

    public void handle(Object msg) {
        this.handler.doHandle(this, msg);
    }

    void runNext(Object msg) {
        if (this.next != null) {
            this.next.handle(msg);
        }
    }

    public long getPreProcessingTime() {
        return preProcessingTime;
    }
}

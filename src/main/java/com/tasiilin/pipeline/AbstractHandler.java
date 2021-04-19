package com.tasiilin.pipeline;

public abstract class AbstractHandler {
    public abstract void doHandle(HandlerContext context, Object msg);
}

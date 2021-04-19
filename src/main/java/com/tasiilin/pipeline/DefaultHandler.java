package com.tasiilin.pipeline;

/**
 * 默认处理器抽象类
 * 默认继续在{@link #handle(HandlerContext, Object)}返回不为空时向后传播，
 */
public abstract class DefaultHandler<T> extends AbstractHandler {

    private HandlerContext context;

    @Override
    public void doHandle(HandlerContext context, Object msg) {
        this.context = context;
        @SuppressWarnings("unchecked")
        T cast = (T) msg;
        Object afterHandleObj = handle(context, cast);
        if (afterHandleObj != null) {
            fireHandler(afterHandleObj);
        }
    }

    protected void fireHandler(Object msg) {
        context.runNext(msg);
    }

    public abstract Object handle(HandlerContext context, T msg);

}

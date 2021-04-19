package com.tasiilin.pipeline;

/**
 * 默认尾部处理器抽象类
 * 该处理器默认不再继续向后传播，一般只放在传播链尾部。
 * 如果添加在传播链中间会导致后续处理器不能接受到该次传播，即后续处理器都是无效的。
 */
public abstract class DefaultEndHandler<T> extends AbstractHandler {
    @Override
    public void doHandle(HandlerContext context, Object msg) {
        @SuppressWarnings("unchecked")
        T cast = (T) msg;
        handle(context, cast);
    }

    public abstract void handle(HandlerContext context, T msg);
}

package com.tasiilin.pipeline;

public class Pipeline {

    private final HandlerContext head = new HandlerContext(new DefaultHandler<Object>() {
        @Override
        public Object handle(HandlerContext context, Object obj) {
            return obj;
        }
    });

    public Pipeline addLast(AbstractHandler handler) {
        HandlerContext context = head;
        while (context.next != null) {
            context = context.next;
        }
        context.next = new HandlerContext(handler);
        return this;
    }

    public void start(Object msg) {
        this.head.handle(msg);
    }

}

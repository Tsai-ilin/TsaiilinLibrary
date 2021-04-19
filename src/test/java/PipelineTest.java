import com.tasiilin.pipeline.DefaultHandler;
import com.tasiilin.pipeline.HandlerContext;
import com.tasiilin.pipeline.Pipeline;

public class PipelineTest {
    public static void main(String[] args) {
        Pipeline pipeline = new Pipeline();
        pipeline.addLast(new DefaultHandler<String>() {
            @Override
            public Object handle(HandlerContext context, String msg) {
                System.out.println("pre first process time: " + context.getPreProcessingTime());
                try {
                    Thread.sleep(3*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "a";
            }
        });

        pipeline.addLast(new DefaultHandler<String>() {

            @Override
            public Object handle(HandlerContext context, String msg) {
                System.out.println("ss: " + context.getPreProcessingTime());
                return "s";
            }
        });

        pipeline.addLast(new DefaultHandler<String>() {

            @Override
            public Object handle(HandlerContext context, String msg) {
                System.out.println("ssa: " + context.getPreProcessingTime());
                return "s";
            }
        });

        pipeline.start("a");
    }

}

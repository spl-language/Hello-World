package simpletruffle;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;

import java.io.File;
import java.io.IOException;

public class Main {

    public static final String HELLO = "hello";

    public static void main(String[] args) throws IOException {
        Source.Builder hello = Source.newBuilder(HELLO, new File("test"));
        System.exit(execute(hello.build()));
    }

    private static int execute(Source source) {
        Context context = Context.newBuilder(HELLO).in(System.in).out(System.out).build();
        context.eval(source);
        context.close();
        return 0;
    }
}

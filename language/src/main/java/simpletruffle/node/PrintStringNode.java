package simpletruffle.node;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.GenerateWrapper;
import simpletruffle.runtime.HelloNull;

@NodeChild
public abstract class PrintStringNode extends HelloBaseNode {

    @Specialization
    protected HelloNull print(String string) {
        System.out.println(string);
        return HelloNull.SINGLETON;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return HelloNull.SINGLETON;
    }

    @Fallback
    protected Object typeError(Object left) {
        throw new RuntimeException();
    }
}

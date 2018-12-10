package simpletruffle.node;

import com.oracle.truffle.api.frame.VirtualFrame;

public final class HelloStringNode extends HelloBaseNode {

    private final String value;

    public HelloStringNode(String value) {
        this.value = value;
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        executeGeneric(frame);
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public boolean isInstrumentable() {
        return false;
    }
}

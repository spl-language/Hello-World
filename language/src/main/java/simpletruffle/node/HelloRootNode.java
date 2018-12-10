package simpletruffle.node;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;
import simpletruffle.HelloLanguage;

public class HelloRootNode extends RootNode {

    @Child private HelloBaseNode statementNode;

    public HelloRootNode(TruffleLanguage<?> language, FrameDescriptor frameDescriptor, HelloBaseNode statementNode) {
        super(language, frameDescriptor);
        this.statementNode = statementNode;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        assert getLanguage(HelloLanguage.class).getContextReference().get() != null;
        return statementNode.executeGeneric(frame);
    }
}

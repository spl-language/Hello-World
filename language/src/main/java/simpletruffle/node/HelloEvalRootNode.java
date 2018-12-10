package simpletruffle.node;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.RootNode;

public class HelloEvalRootNode extends RootNode {

    @Child private DirectCallNode mainCallNode;

    public HelloEvalRootNode(TruffleLanguage<?> language, RootCallTarget rootCallTarget) {
        super(language);
        this.mainCallNode = DirectCallNode.create(rootCallTarget);
    }

    public HelloEvalRootNode(TruffleLanguage<?> language, FrameDescriptor frameDescriptor, DirectCallNode mainCallNode) {
        super(language, frameDescriptor);
        this.mainCallNode = mainCallNode;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return mainCallNode.call(frame.getArguments());
    }
}

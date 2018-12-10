package simpletruffle;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleLanguage.Registration;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.source.Source;
import simpletruffle.node.HelloEvalRootNode;
import simpletruffle.parser.HelloParser;
import simpletruffle.runtime.HelloContext;

import java.util.List;

@Registration(id = HelloLanguage.ID, name = "HELLO")
public class HelloLanguage extends TruffleLanguage<HelloContext> {

    public static final String ID = "hello";

    @Override
    protected HelloContext createContext(Env env) {
        return new HelloContext(this, env);
    }

    @Override
    protected boolean isObjectOfLanguage(Object object) {
        return object instanceof TruffleObject;
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        Source source = request.getSource();
        List<RootCallTarget> rootCallTargets = HelloParser.parseSL(this, source);
        RootCallTarget rootCallTarget = rootCallTargets.get(0);
        HelloEvalRootNode helloEvalRootNode = new HelloEvalRootNode(this, rootCallTarget);
        return Truffle.getRuntime().createCallTarget(helloEvalRootNode);
    }
}

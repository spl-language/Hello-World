package simpletruffle.parser;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import org.antlr.v4.runtime.Token;
import simpletruffle.HelloLanguage;
import simpletruffle.node.HelloRootNode;
import simpletruffle.node.HelloStringNode;
import simpletruffle.node.PrintStringNode;
import simpletruffle.node.PrintStringNodeGen;

import java.util.ArrayList;
import java.util.List;

public class HelloNodeFactory {

    private final HelloLanguage language;
    private List<RootCallTarget> rootCallTargets;

    public HelloNodeFactory(HelloLanguage language) {
        this.language = language;
        this.rootCallTargets = new ArrayList<>();
    }

    /**
     * Метод для створення простої вершини яка буде містити заданий користувачем текст
     */
    public void createHelloNode(Token id) {
        HelloStringNode helloStringNode = new HelloStringNode(id.getText());

        PrintStringNode printStringNode = PrintStringNodeGen.create(helloStringNode);

        HelloRootNode helloEvalRootNode = new HelloRootNode(language, new FrameDescriptor(), printStringNode);
        rootCallTargets.add(Truffle.getRuntime().createCallTarget(helloEvalRootNode));
    }

    public List<RootCallTarget> getAllNodes() {
        return rootCallTargets;
    }
}

package simpletruffle.node;

import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.GenerateWrapper;
import com.oracle.truffle.api.instrumentation.InstrumentableNode;
import com.oracle.truffle.api.instrumentation.ProbeNode;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;

/**
 * Базовий для всіх вершин клас
 */
@TypeSystemReference(HelloTypes.class)
@NodeInfo(language = "hello")
@GenerateWrapper
public abstract class HelloBaseNode extends Node implements InstrumentableNode {

    /**
     * Виконанная без отримання результату.
     * Наприклад виведення в консоль.
     */
    public abstract void executeVoid(VirtualFrame frame);

    /**
     * Виконання з отриманням значення.
     * Наприклад оператор +
     */
    public abstract Object executeGeneric(VirtualFrame frame);

    @Override
    public WrapperNode createWrapper(ProbeNode probe) {
        return new HelloBaseNodeWrapper(this, probe);
    }

    /**
     * Використовується для відлагоджування
     * (не будемо розглядати в заданому прикладі.
     */
    @Override
    public boolean isInstrumentable() {
        return true;
    }
}

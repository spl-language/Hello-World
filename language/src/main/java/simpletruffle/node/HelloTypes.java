package simpletruffle.node;

import com.oracle.truffle.api.dsl.TypeCast;
import com.oracle.truffle.api.dsl.TypeCheck;
import com.oracle.truffle.api.dsl.TypeSystem;
import simpletruffle.runtime.HelloNull;

/**
 * Анотація TypeSystem використовується для визначення типів в системі
 */
@TypeSystem({String.class, HelloNull.class})
public class HelloTypes {

    /**
     * Перевірка чи об'єкт типу HelloNull
     */
    @TypeCheck(HelloNull.class)
    public static boolean isHelloNull(Object value) {
        return value == HelloNull.SINGLETON;
    }

    /**
     * Перетворення типів
     */
    @TypeCast(HelloNull.class)
    public static HelloNull asHelloNull(Object value) {
        assert isHelloNull(value);
        return HelloNull.SINGLETON;
    }
}

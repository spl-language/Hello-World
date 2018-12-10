package simpletruffle.runtime;

import com.oracle.truffle.api.interop.ForeignAccess;
import com.oracle.truffle.api.interop.TruffleObject;

public final class HelloNull implements TruffleObject {

    /**
     * Канонічне значення яке відповідає {@code null} в мові.
     * Існує в єдиному екземплярі.
     */
    public static final HelloNull SINGLETON = new HelloNull();

    private HelloNull() {
    }

    @Override
    public String toString() {
        return "null";
    }

    @Override
    public ForeignAccess getForeignAccess() {
        return HelloNullMessageResolutionForeign.ACCESS;
    }
}

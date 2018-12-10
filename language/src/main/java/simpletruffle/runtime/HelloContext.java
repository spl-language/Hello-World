package simpletruffle.runtime;

import com.oracle.truffle.api.TruffleLanguage;
import simpletruffle.HelloLanguage;

public class HelloContext {

    private final HelloLanguage helloLanguage;
    private final TruffleLanguage.Env env;

    public HelloContext(HelloLanguage helloLanguage, TruffleLanguage.Env env) {
        this.helloLanguage = helloLanguage;
        this.env = env;
    }
}

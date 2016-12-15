package com.chf.example.jdk.script;

import java.io.InputStreamReader;
import java.io.Reader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class JavaScriptEngine {

    private ScriptEngine engine;

    private Invocable invocable;

    public JavaScriptEngine() {
        engine = ScriptEngineUtil.getEngineByName("javascript");
        Reader scriptReader = new InputStreamReader(getClass().getResourceAsStream("function.js"));
        try {
            engine.eval(scriptReader);
            if (engine instanceof Invocable) {
                invocable = (Invocable) engine;
            }
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public Object eval(String script) throws ScriptException {
        return engine.eval(script);
    }

    public Object invoke(String funName, Object... args) throws NoSuchMethodException, ScriptException {
        if (invocable != null) {
            return invocable.invokeFunction(funName, args);
        }
        throw new NoSuchMethodException("Invocable is null.");
    }

}

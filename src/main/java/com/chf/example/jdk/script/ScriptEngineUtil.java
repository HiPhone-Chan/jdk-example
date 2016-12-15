package com.chf.example.jdk.script;

import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class ScriptEngineUtil {

    private static ScriptEngineManager manager = new ScriptEngineManager();

    public static ScriptEngine getEngineByExtension(String extension) {
        return manager.getEngineByExtension("js");
    }

    public static ScriptEngine getEngineByMimeType(String mimeType) {
        return manager.getEngineByExtension(mimeType);
    }

    public static ScriptEngine getEngineByName(String name) {
        return manager.getEngineByName(name);
    }

    public static void support() {
        List<ScriptEngineFactory> factories = manager.getEngineFactories();
        for (ScriptEngineFactory factory : factories) {
            System.out.println("egine name:" + factory.getEngineName());
            System.out.println("engine version:" + factory.getEngineVersion());
            System.out.println("language name:" + factory.getLanguageName());
            System.out.println(factory.getNames());
        }
    }

}

package com.chf.example.jdk.script;

import java.util.Map;

import domain.A;

public class Javacript {

    public static void main(String[] args) throws Exception {
        String exp1 = "1+1;";
        String exp2 = "Math.round(0.005 * 100) /100";

        JavaScriptEngine engine = new JavaScriptEngine();

        System.out.println(engine.eval(exp1));
        System.out.println(engine.eval(exp2));

        System.out.println(engine.invoke("add", 1, 2));
        System.out.println(engine.invoke("max", 1, 2));
        Map<?, ?> dict = (Map<?, ?>) engine.invoke("dict", 1, 3);

        for (Object o : dict.keySet()) {
            System.out.println(o + " : " + dict.get(o));
        }

        Map<?, ?> arr = (Map<?, ?>) engine.invoke("array", 1);
        for (Object o : arr.keySet()) {
            System.out.println(o + " : " + arr.get(o));
        }

        Object nullObj = engine.invoke("null_func");
        System.out.println(nullObj);

        A a = new A(2, "hi");
        System.out.println(engine.invoke("obj_func", a));
        ScriptEngineUtil.support();
    }

}

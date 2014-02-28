package org.jimwu.java7.demo;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by Jim.wu on 14-2-28.
 */
public class ScriptEngineDemo {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineDemo scriptEngineDemo = new ScriptEngineDemo();
        scriptEngineDemo.helloJavaScript();
    }

    public void helloJavaScript() throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager()
                .getEngineByName("JavaScript");
        engine.eval("println('yoyo');");

    }
}

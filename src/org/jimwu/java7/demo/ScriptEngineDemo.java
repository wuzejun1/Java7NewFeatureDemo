package org.jimwu.java7.demo;

import javax.script.*;

/**
 * Created by Jim.wu on 14-2-28.
 */
public class ScriptEngineDemo {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngineDemo scriptEngineDemo = new ScriptEngineDemo();
        System.out.println("helloJavaScript==================================");
        scriptEngineDemo.helloJavaScript();
        System.out.println("helloJavaScript==================================");
        System.out.println("useDefaultBinding==================================");
        scriptEngineDemo.useDefaultBinding();
        System.out.println("useDefaultBinding==================================");
        System.out.println("useCustomBinding==================================");
        scriptEngineDemo.useCustomBinding();
        System.out.println("useDefaultBinding==================================");
        System.out.println("invokeFunction==================================");
        scriptEngineDemo.invokeFunction();
        System.out.println("invokeFunction==================================");
    }

    public void helloJavaScript() throws ScriptException {
        getJavaScriptEngine().eval("println('yoyo');");
    }

    public ScriptEngine getJavaScriptEngine() {
        return new ScriptEngineManager()
                .getEngineByName("JavaScript");
    }

    public void invokeFunction() throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = getJavaScriptEngine();
        String scriptText = "function greet(name) { println('Hello, ' + name);}";
        engine.eval(scriptText);
        Invocable invocable = (Invocable) engine;
        invocable.invokeFunction("greet", "Alex");
    }

    public void useDefaultBinding() throws ScriptException {
        ScriptEngine engine = getJavaScriptEngine();
        engine.put("name", "Alex");
        engine.eval("var message = 'Hello,' + name;");
        engine.eval("println('JavaScript:' + message);");
        Object obj = engine.get("message");
        System.out.println("Java:" + obj);
    }

    public void useCustomBinding() throws ScriptException {
        ScriptEngine engine = getJavaScriptEngine();
        Bindings bindings = new SimpleBindings();
        bindings.put("hobby", "playing games");
        engine.eval("println('I like ' + hobby);", bindings);
    }
}

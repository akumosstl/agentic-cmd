package io.github.akumosstl.agentic.work;


public class ScriptClient {
    public static String callScript(String prompt) {
        return ScriptRunner.runCommandAndGetSpecificOutput(prompt);
    }
}


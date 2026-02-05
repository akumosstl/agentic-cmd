package io.github.akumosstl.agentic.work;

import java.nio.file.Files;
import java.nio.file.Path;

public class Orchestrator {

    public static void main(String[] args) throws Exception {

        var isScript_var = System.getenv("SCRIPT");

        if (isScript_var != null && isScript_var.equals("true")) {
            System.out.println(ScriptClient.callScript(System.getenv("ACTION")));
        } else {
            var action_var = System.getenv("ACTION");
            var feature = Files.readString(Path.of(action_var));
            //System.out.println(CopilotClient.callCopilot(feature));
            CopilotClient.callCopilot(feature);
        }

    }
}

package io.github.akumosstl.agentic.work;


public class CopilotClient {
    public static String callCopilot(String prompt) {
        String[] command = {
                "copilot",
                "--allow-all-paths",
                "--allow-all-tools",
                "-p",
                JsonEscaper.escapeJsonForWindowsCmd(prompt.replaceAll("\\R", " "))
        };
        return ProcessRunner.runCommandAndGetSpecificOutput(command);
    }
}


package io.github.akumosstl.agentic.work;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ScriptRunner {


    /**
     * Executes a shell command, captures all output, and returns a specific
     * substring of the output up to the line starting with "Total usage est:".
     *
     * @param command The command and its arguments as an array of Strings.
     * @return The relevant console output as a single String, or an error message.
     */
    public static String runCommandAndGetSpecificOutput(String command) {
        StringBuilder fullOutput = new StringBuilder();

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/C", command);
            processBuilder.redirectErrorStream(true); // Merge stdout and stderr

            File workingDir = new File(System.getProperty("user.home")  + File.separator + ".agentic" + File.separator + "scripts");

            processBuilder.directory(workingDir);
            Process process = processBuilder.start();

            // Read the entire output stream into a single StringBuilder
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                fullOutput.append(reader.lines().collect(Collectors.joining(System.lineSeparator())));
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();
            System.out.println("\nCommand exited with code: " + exitCode);

            return fullOutput.toString();

        } catch (IOException e) {
            return "Error running command (IOException): " + e.getMessage();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupt flag
            return "Error running command (InterruptedException): " + e.getMessage();
        }
    }
}


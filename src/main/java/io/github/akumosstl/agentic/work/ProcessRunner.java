package io.github.akumosstl.agentic.work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ProcessRunner {

    /**
     * Executes a shell command, captures all output, and returns a specific
     * substring of the output up to the line starting with "Total usage est:".
     * Prints output to System.out in real time as it is produced.
     *
     * @param command The command and its arguments as an array of Strings.
     * @return The relevant console output as a single String, or an error message.
     */
    public static String runCommandAndGetSpecificOutput(String[] command) {
        StringBuilder fullOutput = new StringBuilder();

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true); // Merge stdout and stderr
            Process process = processBuilder.start();

            // Read and print output in real time
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line); // Print each line as soon as it's available
                    fullOutput.append(line).append(System.lineSeparator());
                }
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();
            System.out.println("\nCommand exited with code: " + exitCode);

            // Now, parse the full output string
            return fullOutput.toString();

        } catch (IOException e) {
            return "Error running command (IOException): " + e.getMessage();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupt flag
            return "Error running command (InterruptedException): " + e.getMessage();
        }
    }
}

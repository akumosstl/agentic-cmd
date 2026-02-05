package io.github.akumosstl.agentic.work;

public class JsonEscaper {

    /**
     * Escapes a JSON string to be safely passed as a command line argument on Windows.
     *
     * @param jsonInput The original JSON string.
     * @return The escaped JSON string wrapped in double quotes.
     */
    public static String escapeJsonForWindowsCmd(String jsonInput) {
        if (jsonInput == null || jsonInput.isEmpty()) {
            return "\"\""; // Return empty string wrapped in quotes
        }

        // 1. Escape the double quotes within the JSON string with a backslash.
        String escapedInnerQuotes = jsonInput.replace("\"", "\\\"");

        // 2. Wrap the entire resulting string in double quotes for the command line.
        String finalCmdArgument = "\"" + escapedInnerQuotes + "\"";

        return finalCmdArgument;
    }

    // Example Usage:
    public static void main(String[] args) {
        String originalJson = "{\"name\": \"John Doe\", \"age\": 30, \"city\": \"New York\"}";
        String cmdArgument = escapeJsonForWindowsCmd(originalJson);

        System.out.println("Original JSON: " + originalJson);
        System.out.println("Command Line Argument: " + cmdArgument);

        // Example of how you might use this with ProcessBuilder or Runtime.exec()
        // The resulting 'cmdArgument' is ready to be an element in a command array.
    }
}

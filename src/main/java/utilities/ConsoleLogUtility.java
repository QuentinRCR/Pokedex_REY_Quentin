package utilities;

import views.OutputGeneratorToTextInterface;


public class ConsoleLogUtility {

    /**
     * Output a formatted text to the console
     */
    public static void logTextToConsole(OutputGeneratorToTextInterface generator) {
        System.out.println(generator.generateText());
    }
}
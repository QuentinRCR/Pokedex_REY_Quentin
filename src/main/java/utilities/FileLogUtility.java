package utilities;

import views.OutputGeneratorToHTMLInterface;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLogUtility {

    /**
     * Output a html text format to a file located a filePath
      * @param filePath
     * @param generator
     * @throws IOException
     */
    public static void logHtmlToFile(String filePath, OutputGeneratorToHTMLInterface generator) throws IOException {
            Files.write(Paths.get(filePath), generator.generateHtml().getBytes(StandardCharsets.UTF_8));
    }

}
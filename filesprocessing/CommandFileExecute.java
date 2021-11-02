package filesprocessing;

import filesprocessing.exception.MissingSubSectionException;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * checks if the file is divided to legal sub-sections
 */
public class CommandFileExecute {

    private String commandFile;

    /**
     * the constructor of CommandFileExecute
     *
     * @param commandFilePath the string path of the file being checked
     */
    CommandFileExecute(String commandFilePath) {

        this.commandFile = commandFilePath;

    }

    /**
     * checks each sub-section to contain both FILTER and ORDER.
     *
     * @return list of sub-sections
     * @throws IOException       exceptions that has to do with the file
     * @throws MissingSubSectionException subSection missing exception
     */
    List<List<String>> checkIfFileIsValid() throws IOException, MissingSubSectionException {

        List<String> lines = Files.readAllLines(Paths.get(commandFile));

        List<List<String>> allSection = new ArrayList<>();

        List<String> section = new ArrayList<>();

        int lineCounter = 1;

        for (int i = 0; i < lines.size(); i++) {

            if (lineCounter == 4 || i == lines.size() - 1 || lineCounter == 3 &&
                    lines.get(i + 1).equals("FILTER")) {
                section.add(lines.get(i));

                if (section.size() < 3) {
                    throw new MissingSubSectionException("FILTER OR ORDER");

                } else if (!section.get(0).equals("FILTER")) {
                    throw new MissingSubSectionException("FILTER");

                } else if (!section.get(2).equals("ORDER")) {
                    throw new MissingSubSectionException("ORDER");
                }
                allSection.add(section);
                section = new ArrayList<>();
                lineCounter = 0;
            } else {
                section.add(lines.get(i));
            }
            lineCounter++;
        }
        return allSection;
    }
}

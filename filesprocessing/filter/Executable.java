package filesprocessing.filter;

import java.io.File;

/**
 * filters the files by their ability to execute
 */
public class Executable implements Filter {

    /**
     * a string representing if the file is executable or not
     */
    private String isExecutable;

    /**
     * the constructor of executable filesprocessing.filter
     * @param isExecutable a string representing if the file is executable or not
     */
    public Executable(String isExecutable) {

        this.isExecutable = isExecutable;

    }

    @Override
    public boolean isPass(File file) {

        if (isExecutable.equals("NO")) {
            return !file.canExecute();
        } else {
            return file.canExecute();
        }
    }

}

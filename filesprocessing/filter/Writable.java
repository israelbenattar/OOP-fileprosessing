package filesprocessing.filter;

import java.io.File;

/**
 * a class that filters files by their ability to be written
 */
public class Writable implements Filter {

    /**
     * a string representing if the file is writable or not
     */
    private String isWritable;

    /**
     * the constructor of a writable filesprocessing.filter
     * @param isWritable a string representing if the file is writable or not
     */
    public Writable(String isWritable) {

        this.isWritable = isWritable;

    }

    @Override
    public boolean isPass(File file) {

        if (isWritable.equals("NO")) {
            return !file.canWrite();
        } else {
            return file.canWrite();
        }
    }

}

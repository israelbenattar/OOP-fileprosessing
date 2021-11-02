package filesprocessing.filter;

import java.io.File;

/**
 * an interface responsible to return only the files that answer the requirements of the filesprocessing.filter
 */
public interface Filter {

    /**
     * Check whether the file pass the filesprocessing.filter
     *
     * @param file The file to check.
     * @return True if the file pass the filesprocessing.filter, false otherwise.
     */
    public boolean isPass(File file);

}

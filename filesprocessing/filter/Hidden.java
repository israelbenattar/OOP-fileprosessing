package filesprocessing.filter;

import java.io.File;

/**
 * filters the file if it is a hidden file
 */
public class Hidden implements Filter {

    /**
     * a string representing if the file is hidden or not
     */
    private String isHidden;

    /**
     * the constructor of hidden filesprocessing.filter
     * @param isHidden a string representing if the file is hidden or not
     */
    public Hidden(String isHidden) {

        this.isHidden = isHidden;

    }

    @Override
    public boolean isPass(File file) {

        if (isHidden.equals("NO")) {
            return !file.isHidden();

        } else {
            return file.isHidden();
        }
    }

}

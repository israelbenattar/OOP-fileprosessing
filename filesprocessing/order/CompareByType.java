package filesprocessing.order;

import java.io.File;
import java.util.Comparator;

/**
 * an comparator that compare by the type of two files.
 */

public class CompareByType implements Comparator<File> {


    @Override
    public int compare(File o1, File o2) {
        if (getFileExtension(o1).compareTo(getFileExtension(o2)) == 0){
            return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
        }
        return getFileExtension(o1).compareTo(getFileExtension(o2));
    }

    /**
     *
     * @param file file to get it's extension
     * @return the file's extension
     */
    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }
}

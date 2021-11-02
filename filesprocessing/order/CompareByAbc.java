package filesprocessing.order;

import java.io.File;
import java.util.Comparator;

/**
 * an comparator that compare by the name of two files.
 */

public class CompareByAbc implements Comparator<File> {

    @Override
    public int compare(File o1, File o2) {
        return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
    }
}

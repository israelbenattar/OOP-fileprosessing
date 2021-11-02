package filesprocessing.order;

import java.io.File;
import java.util.Comparator;

/**
 * an comparator that compare by the size of two files.
 */


public class CompareBySize implements Comparator<File> {

    @Override
    public int compare(File o1, File o2) {
        if (o1.length() == o2.length()){
            return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
        }
        return Long.compare(o1.length(), o2.length());
    }


}

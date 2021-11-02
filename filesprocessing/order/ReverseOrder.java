package filesprocessing.order;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class is used as a wrapper class for an order type object
 * whose purpose is to reverse the order of a given Order type object.
 */

public class ReverseOrder extends Order{


    /**
     * @param comparator the comparator for the currant order.
     */
    public ReverseOrder(Comparator<File> comparator) {

        super(comparator);

    }


    public File[] orderFile(File[] fileDir) {
        File[] fileToReverse = super.orderFile(fileDir);
        Collections.reverse(Arrays.asList(fileToReverse));
        return fileToReverse;
    }
}

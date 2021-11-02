package filesprocessing.filter;

import java.io.File;

/**
 * a class that filters all files that are smaller than a given value
 */
public class SmallerThan implements Filter {

    /**
     * a number representing the lower bound in k-bytes
     */
    private double upperBond;

    /**
     * the constructor of smaller than filesprocessing.filter
     * @param upperBond a number representing the lower bound in k-bytes
     */
    public SmallerThan(double upperBond) {

        this.upperBond = upperBond;

    }

    @Override
    public boolean isPass(File file) {

        double fileSize = (double)file.length()/1024;

        return upperBond > fileSize;

    }

}

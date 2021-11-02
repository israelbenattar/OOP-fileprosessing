package filesprocessing.filter;

import java.io.File;

/**
 * a class that filters all files that are greater than a given value
 */
public class GreaterThan implements Filter {

    /**
     * a number representing the lower bound in k-bytes
     */
    private double lowerBond;

    /**
     * the constructor of greater than filesprocessing.filter
     * @param lowerBond a number representing the lower bound in k-bytes
     */
    public GreaterThan(double lowerBond) {

        this.lowerBond = lowerBond;

    }

    @Override
    public boolean isPass(File file) {

        double fileSize = (double)file.length()/1024;

        return fileSize > lowerBond;

    }

}

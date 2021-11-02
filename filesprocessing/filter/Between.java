package filesprocessing.filter;

import java.io.File;

/**
 * filters only files with a size between the given numbers
 */
public class Between implements Filter {

    /**
     * a number representing the lower bound in k-bytes
     */
    private double lowerBound;

    /**
     * a number representing the upper bound in k-bytes
     */
    private double upperBound;

    /**
     * the constructor of between filesprocessing.filter
     * @param lowerBound the lower bound of a file size
     * @param upperBound the upper bound of a file size
     */
    public Between(double lowerBound, double upperBound){

        this.upperBound = upperBound;

        this.lowerBound = lowerBound;

    }

    @Override
    public boolean isPass(File file){

        double fileSize = (double)file.length()/1024;

        return lowerBound <= fileSize && fileSize <= upperBound;

    }

}

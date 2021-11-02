package filesprocessing.filter;

import java.io.File;

/**
 * This class is used as a wrapper class for a filesprocessing.filter type object
 * whose purpose is to reverse the filesprocessing.filter of a given Filter type object.
 */
public class NotFilter implements Filter {

    /**
     * The wrapped object.
     */
    private Filter filter;

    /**
     * the constructor of the negative filesprocessing.filter
     * @param filter An object of type Filter that we want to wrap.
     */
    public NotFilter(Filter filter){

        this.filter = filter;

    }

    @Override
    public boolean isPass(File file) {

        return !filter.isPass(file);

    }
}

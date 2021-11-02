package filesprocessing.filter;

import java.io.File;

/**
 * a filesprocessing.filter that always returns true as if all files pass the filesprocessing.filter
 */
public class All implements Filter{

    @Override
    public boolean isPass(File file){
        return true;
    }


}

package filesprocessing.filter;

import java.io.File;

/**
 * a class that filters files by checking if the given value is their name suffix
 */
public class SuffixValue implements Filter{

    /**
     * the value being checked if is the name suffix
     */
    private String value;

    /**
     * the constructor of suffix filesprocessing.filter
     * @param value the value being checked if is the name suffix
     */
    public SuffixValue(String value){

        this.value = value;

    }

    @Override
    public boolean isPass(File file) {

        return file.getName().endsWith(value);

    }

}

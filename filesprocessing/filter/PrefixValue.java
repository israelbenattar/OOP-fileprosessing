package filesprocessing.filter;

import java.io.File;

/**
 * a class that filters files by checking if the given value is their name prefix
 */
public class PrefixValue implements Filter {

    /**
     * the value being checked if is the name prefix
     */
    private String value;

    /**
     * the constructor of prefix filesprocessing.filter
     * @param value the value being checked if is the name suffix
     */
    public PrefixValue(String value){

        this.value = value;

    }

    @Override
    public boolean isPass(File file) {

        return file.getName().startsWith(value);

    }

}
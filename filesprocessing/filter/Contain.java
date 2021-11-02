package filesprocessing.filter;

import java.io.File;

/**
 * filters the files whether their name contain a certain value or not
 */
public class Contain implements Filter {

    /**
     * the value to check if contained
     */
    private String value;

    /**
     * the constructor of contain filesprocessing.filter
     * @param containValue the value to check if contained
     */
    public Contain(String containValue){

        this.value = containValue;

    }

    @Override
    public boolean isPass(File file) {

        return file.getName().contains(value);

    }

}

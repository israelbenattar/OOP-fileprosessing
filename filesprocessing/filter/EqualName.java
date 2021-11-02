package filesprocessing.filter;

import java.io.File;

/**
 * filters the files whether their name equal to a certain value or not
 */
public class EqualName implements Filter {

    /**
     * the value to compare
     */
    private String fileName;

    /**
     * the constructor of equal name filesprocessing.filter
     * @param fileName the value to compare
     */
    public EqualName(String fileName){

        this.fileName = fileName;

    }

    @Override
    public boolean isPass(File file) {

        return fileName.equals(file.getName());

    }

}

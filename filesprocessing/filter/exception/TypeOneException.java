package filesprocessing.filter.exception;

/**
 * a class of type one exceptions, which prints a warning to the screen
 */
public class TypeOneException extends Exception {

    public TypeOneException(int lineNumber){
        System.err.println("Warning in line " + lineNumber);
    }
}

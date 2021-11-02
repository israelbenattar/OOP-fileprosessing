package filesprocessing.exception;

public class MissingSubSectionException extends Exception {

    public MissingSubSectionException(String subSec) {
        System.err.println(("ERROR: a " + subSec + " sub-section is missing. \n"));
    }
}

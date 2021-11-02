package filesprocessing.filter;

import filesprocessing.filter.exception.TypeOneException;

/**
 * a Filter objects factory, which gets a list of parameters and returns a filesprocessing.filter object according to
 * those parameters
 */
public class FilterFactory {

    //File size is strictly greater than the given number of k-bytes
    private final String GREATER_THAN = "greater_than";

    //File size is between (inclusive) the given numbers (in k-bytes)
    private final String BETWEEN = "between";

    //File size is strictly less than the given number of k-bytes
    private final String SMALLER_THAN = "smaller_than";

    //value equals the file name (excluding path)
    private final String FILE = "file";

    //value is contained in the file name (excluding path)
    private final String CONTAINS = "contains";

    //value is the prefix of the file name (excluding path)
    private final String PREFIX = "prefix";

    //value is the suffix of the file name (excluding path)
    private final String SUFFIX = "suffix";

    //Does file have writing permission? (for the current user)
    private final String WRITABLE = "writable";

    //Does file have execution permission? (for the current user)
    private final String EXECUTABLE = "executable";

    //Is the file a hidden file?
    private final String HIDDEN = "hidden";

    //all files are matched
    private final String ALL = "all";
    /**
     *
     * @param filter the line describing the wanted filesprocessing.filter
     * @param line number of line in the file being read
     * @return the appropriate Filter after checking if needed to be the negative one
     */
    public Filter createFilter(String[] filter, int line) {

        boolean isContainNot = containNot(filter);

        try {

            if (filter[0].equals(GREATER_THAN)) {
                double lowerBond = Double.parseDouble(filter[1]);
                if (lowerBond < 0 || (isContainNot && filter.length > 3)
                        || (!isContainNot && filter.length > 2)) {
                    throw new TypeOneException(line);
                }
                return getFilter(new GreaterThan(lowerBond), isContainNot);

            } else if (filter[0].equals(BETWEEN)) {
                double lowerBond = Double.parseDouble(filter[1]);
                double upperBond = Double.parseDouble(filter[2]);

                if (lowerBond > upperBond || lowerBond < 0 || upperBond < 0) {
                    throw new TypeOneException(line);
                }
                return getFilter(new Between(lowerBond, upperBond), isContainNot);

            } else if (filter[0].equals(SMALLER_THAN)) {
                double upperBond = Double.parseDouble(filter[1]);
                if (upperBond < 0 || (isContainNot && filter.length > 3)
                        || (!isContainNot && filter.length > 2)) {
                    throw new TypeOneException(line);
                }
                return getFilter(new SmallerThan(upperBond), isContainNot);

            } else if (filter[0].equals(FILE)) {
                return getFilter(new EqualName(filter[1]), isContainNot);

            } else if (filter[0].equals(CONTAINS)) {
                return getFilter(new Contain(filter[1]), isContainNot);

            } else if (filter[0].equals(PREFIX)) {
                return getFilter(new PrefixValue(filter[1]), isContainNot);

            } else if (filter[0].equals(SUFFIX)) {
                return getFilter(new SuffixValue(filter[1]), isContainNot);

            } else if (filter[0].equals(WRITABLE)) {
                if (filter.length < 2 || !filter[1].equals("NO") && !filter[1].equals("YES")) {
                    throw new TypeOneException(line);
                }
                return getFilter(new Writable(filter[1]), isContainNot);

            } else if (filter[0].equals(EXECUTABLE)) {
                if (filter.length < 2 || !filter[1].equals("NO") && !filter[1].equals("YES")) {
                    throw new TypeOneException(line);
                }
                return getFilter(new Executable(filter[1]), isContainNot);

            } else if (filter[0].equals(HIDDEN)) {
                if (filter.length < 2 || !filter[1].equals("NO") && !filter[1].equals("YES")) {
                    throw new TypeOneException(line);
                }
                return getFilter(new Hidden(filter[1]), isContainNot);

            } else if (filter[0].equals(ALL)) {
                return getFilter(new All(), isContainNot);

            } else {
                throw new TypeOneException(line);

            }
        } catch (TypeOneException e){
            return new All();
        }

    }


    /**
     * checks if the filesprocessing.filter should be opposite or not
     * @param myFilter the filesprocessing.filter that is being checked if to be the negative
     * @param contain true if need to be opposite
     * @return a Filter type object, the opposite one if need
     */
    private Filter getFilter(Filter myFilter, boolean contain) {
        if (contain) {
            return new NotFilter(myFilter);
        } else {
            return myFilter;
        }
    }

    /**
     * checks if NOT is in the filesprocessing.filter given
     * @param myList the order list
     * @return true if the list contains NOT, false otherwise
     */
    private boolean containNot(String[] myList) {
        for (String value : myList) {
            if (value.equals("NOT")) {
                return true;
            }
        }
        return false;
    }

}

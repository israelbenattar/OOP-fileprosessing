package filesprocessing.order;

import filesprocessing.order.exception.TypeOneException;

import java.util.Comparator;

/**
 * an Order objects factory, which gets a list of parameters and returns an Order object according to
 * those parameters
 */

public class OrderFactory {

    //an abc comparator.
    private Comparator<java.io.File> abcCompare = new CompareByAbc();

    //an size comparator.
    private Comparator<java.io.File> sizeCompare = new CompareBySize();

    //an type comparator.
    private Comparator<java.io.File> typeCompare = new CompareByType();

    /**
     *
     * @param orderType the line describing the wanted order
     * @param line number of line in the file being read
     * @param defaults true if the order is a default order
     * @return the appropriate Order after checking if needed a reverse one
     */
    public Order getOrder(String[] orderType, int line, boolean defaults) {

        Order abcOrder = new Order(abcCompare);

        if (defaults){
            return abcOrder;

        }else {
            boolean isContainReverse = containReverse(orderType);

            try {
                if (orderType[0].equals("abs")) {
                    return getOrder(abcCompare, isContainReverse);

                } else if (orderType[0].equals("type")) {
                    return getOrder(typeCompare, isContainReverse);

                } else if (orderType[0].equals("size")) {
                    return getOrder(sizeCompare, isContainReverse);

                } else {
                    throw new TypeOneException(line);
                }
            } catch (TypeOneException e) {
                return abcOrder;
            }
        }
    }

    /**
     * checks if the order should be reversed or not
     * @param comparator the order that is being checked if to be reversed
     * @param contain true if need to be reversed
     * @return an Order type object, reversed if need
     */
    private Order getOrder(Comparator<java.io.File> comparator, boolean contain) {

        if (contain) {
            return new ReverseOrder(comparator);

        } else {
            return new Order(comparator);
        }
    }

    /**
     * checks if reverse is in the order given
     * @param myList the order list
     * @return true if the list contains reverse, false otherwise
     */
    private boolean containReverse(String[] myList) {
        for (String value : myList) {
            if (value.equals("REVERSE")) {
                return true;
            }
        }
        return false;
    }
}

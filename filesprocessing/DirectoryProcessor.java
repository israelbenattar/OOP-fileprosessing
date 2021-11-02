package filesprocessing;

import filesprocessing.exception.IncorrectNumberOfArgsException;
import filesprocessing.exception.MissingSubSectionException;
import filesprocessing.filter.*;
import filesprocessing.order.Order;
import filesprocessing.order.OrderFactory;

import java.io.*;
import java.util.*;

/**
 * the class is responsible to the running of the program
 */
public class DirectoryProcessor {

    /**
     * the main method which runs the whole program
     *
     * @param args sourcedir and commandfile
     */
    public static void main(String[] args) {

        try {
            if (args.length != 2) {
                throw new IncorrectNumberOfArgsException();
            }
        } catch (IncorrectNumberOfArgsException e) {
            return;
        }

        File sourceDirectory = new File(args[0]);

        CommandFileExecute myCom = new CommandFileExecute(args[1]);

        List<List<String>> mySection;
        try {
            mySection = myCom.checkIfFileIsValid();
        } catch (IOException | MissingSubSectionException e) {
            return;
        }

        FilterFactory myFilterFactory = new FilterFactory();

        OrderFactory myOrderFactory = new OrderFactory();

        int line = 1;

        for (List<String> command : mySection) {
            Filter myFilter = myFilterFactory.createFilter(command.get(1).split("#"), line + 1);

            Order myOrder = myOrderFactory.getOrder(command.get(command.size() - 1).split("#"),
                    line + command.size() - 1, command.size() == 3);

            List<File> outList = new ArrayList<>();

            for (File myFile : Objects.requireNonNull(sourceDirectory.listFiles())) {

                if (!myFile.isDirectory() && myFilter.isPass(myFile)) {
                    outList.add(myFile);
                }
            }
            File[] orderList = myOrder.orderFile(outList.toArray(new File[0]));

            for (File value : orderList) {
                System.out.println(value.getName());
            }
            line = line + command.size();
        }

    }

}

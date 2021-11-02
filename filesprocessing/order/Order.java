package filesprocessing.order;

import java.io.File;
import java.util.Comparator;

/**
 * an class responsible for the order in which the filtered files are printed
 */

public class Order {

    private Comparator<File> myComparator;

    /**
     * @param comparator the comparator for the currant order.
     */
    public Order(Comparator<File> comparator) {

        this.myComparator = comparator;

    }

    /**
     * @param fileDir the list of files that is being ordered.
     * @return the sorted list.
     */
    public File[] orderFile(File[] fileDir) {
        mergeSort(fileDir, fileDir.length, myComparator);
        return fileDir;
    }

    /**
     *
     * @param a the list of files that is being ordered.
     * @param n the length of the file list.
     * @param comparator the comparator for the currant order.
     */
    private static void mergeSort(File[] a, int n, Comparator<File> comparator) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        File[] l = new File[mid];
        File[] r = new File[n - mid];

        System.arraycopy(a, 0, l, 0, mid);
        System.arraycopy(a, mid, r, 0, n - mid);
        mergeSort(l, mid, comparator);
        mergeSort(r, n - mid, comparator);

        merge(a, l, r, mid, n - mid, comparator);
    }

    private static void merge(File[] a, File[] l, File[] r, int left, int right,
                              Comparator<File> comparator) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (comparator.compare(l[i], r[j]) <= 0) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

}

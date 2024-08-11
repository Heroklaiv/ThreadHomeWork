import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort implements Runnable {
    @Override
    public void run() {

    }

    public void bubbleSort(int[] sortArr) {
        for (int i = 0; i < sortArr.length - 1; i++) {
            for (int j = 0; j < sortArr.length - i - 1; j++) {
                if (sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
        }
        printIntArray(sortArr);
    }

    public static synchronized void printIntArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}

import java.util.Arrays;

public class QuickSort implements Runnable{

    @Override
    public void run() {

    }
    public void sort(int[] arr)
    {
       int[] arrCopy = Arrays.stream(arr).sorted().toArray();
        BubbleSort.printIntArray(arrCopy);
    }
}

import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
//Задача 1:
//Пользователь вводит с клавиатуры значение в массив. После чего запускаются два
//потока. Первый поток находит максимум в массиве, второй — минимум. Результаты
//вычислений возвращаются в метод main().
        MaxMin maxMin = new MaxMin();
        CopyOnWriteArrayList<Integer> array = new CopyOnWriteArrayList<>();
        int randomSub;// чтобы самому не вводить и испытывать на большом количестве значений
        for (int i = 0; i <= 100; i++) {
            randomSub = (int) (Math.random() * 1000);
            array.add(randomSub);
        }
        System.out.println(array);

        Thread threadSearchMax = new Thread(() -> {
            Integer min = Integer.MAX_VALUE;

            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) < min) min = (array.get(i));
            }
            maxMin.setMin(min);
        });
        threadSearchMax.start();
        Thread threadSearchMin = new Thread(() -> {
            Integer max = Integer.MIN_VALUE;

            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) > max) max = array.get(i);
            }
            maxMin.setMax(max);
        });
        threadSearchMin.start();
        try {
            threadSearchMax.join();
            threadSearchMin.join();
        } catch (InterruptedException e) {
            System.out.println("KOSYAK");
        }

        System.out.println(maxMin.getMin());
        System.out.println(maxMin.getMax());

        //Задача 2:
        //Сортировка массива цифр в нескольких потоках различными алгоритмами:
        // сортировка вставками;
        // сортировка выбором;
        // сортировка пузырьком.
        //Каждый вид сортировки должен запускаться в отдельном потоке. После вывести
        //результат отсортированных массивов в консоль
        int[] arr = {59, 15, 15, 86, 96, 2, 5, 5, 5, 189, 4, 1, 2};
        Thread sort1 = new Thread(() -> {
            BubbleSort bubbleSort = new BubbleSort();
            bubbleSort.bubbleSort(arr);

        });
        sort1.start();

        Thread sort2 = new Thread(() -> {
            InsertionSort insertionSort = new InsertionSort();
            insertionSort.sort(arr);
        });
        sort2.start();

        Thread sort3 = new Thread(() -> {
            QuickSort quickSort = new QuickSort();
            quickSort.sort(arr);
        });
        sort3.start();

    }


}

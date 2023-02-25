package homework_4;
import java.util.Arrays;
import java.util.logging.*;
import java.io.IOException;

public class piramidSort {
    public static void main(String[] args) throws IOException{
        // Реализовать алгоритм пирамидальной сортировки (HeapSort)
        int[] arr = new int[] {3,1,9,4,5,8,2,7,6};
        System.out.println(Arrays.toString(arr));
        Logger log = Logger.getLogger(piramidSort.class.getName());
        FileHandler fh = new FileHandler("heapSort_log.txt");
        log.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        log.info(Arrays.toString(arr));
        try {
            createHeap(arr,log);
            int n = arr.length;
            for (int i = n - 1; i > 0; i--) {
                swap(arr, 0, i);
                maxHeap(arr, 0, i);
                log.info(Arrays.toString(arr));
            }
        } catch (Exception e) {
            System.out.println("Ошибка!");
        }
        System.out.println(Arrays.toString(arr));
    }
    // строим кучу
    public static void createHeap(int[] arr,Logger log) throws IOException{
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeap(arr, i, n);
            log.info(Arrays.toString(arr));
        }
    }

    public static void maxHeap(int[] arr, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            maxHeap(arr, largest, n);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
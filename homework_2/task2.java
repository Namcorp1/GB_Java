package homework_2;

import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;


/* 2.Реализуйте алгоритм сортировки пузырьком числового массива, 
результат после каждой итерации запишите в лог-файл. */

public class task2 {
    public static void main(String[] args) {
        int[] nums = createArray();
        System.out.println(Arrays.toString(nums));
        try{
            System.out.println(Arrays.toString(BubbleSort(nums)));
        }catch(IOException e){
            System.out.println("Ошибка!");
        }
        
    }
     
    // создадим массив с псевдослучайными числами по вводным параметрам: размер и границы
    private static int[] createArray() {
        Scanner inputData = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = inputData.nextInt();
        System.out.print("Введите нижний предел: ");
        int lBound = inputData.nextInt();
        System.out.print("Введите верхний предел: ");
        int uBound = inputData.nextInt();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = lBound + (int) (Math.random() * ((uBound - lBound) + 1));
        }
        return res;
    }
     
    // сортировка пузырьком
    private static int[] BubbleSort(int[] arr) throws IOException{
        int count = 0;
        int[] copy = Arrays.copyOf(arr, arr.length);
        Logger logger = Logger.getLogger(task2.class.getName());
        FileHandler fh = new FileHandler("sortLog.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter(); // XML формат слишком нагружен, взял обычный
        fh.setFormatter(sFormat); 
        String output = "";
        output += Arrays.toString(arr);
        logger.info(output);
        for (int i = 0; i + 1 < copy.length; i++) {
            for (int j = 0; j + 1 < copy.length - i; j++) {
                if (copy[j + 1] < copy[j]) {
                    int item = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = item;
                    count ++;
                    output = String.format("шаг %d: ",count);
                    output += Arrays.toString(copy);
                    logger.info(output);
                }

            }
        }
        return copy;
    }
}

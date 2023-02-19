package homework_3;

import java.util.Arrays;
import java.util.logging.*;
import java.io.IOException;

public class mergeSort {
    public static void main(String[] args) throws IOException {
        Integer[] arr = new Integer[] { 8, 100, 25, 1, 174, 79, 26, 153 };
        Integer[] sort = arr.clone();
        /*
         * Добавим логирование
         * Для того чтобы не создавался на каждый лог новый файл,
         * иницируем его в main и далее сам лог и хэндлер будем передавать в метод
         */
        Logger log = Logger.getLogger(mergeSort.class.getName());
        FileHandler fh = new FileHandler("mergeSort_log.txt");
        log.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        try {
            sort = mergeSortMethod(sort, fh, log);
        } catch (Exception e) {
            System.out.println("Ошибка!");
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sort));
    }
    private static Integer[] mergeSortMethod(Integer[] arr, FileHandler fh, Logger log) throws IOException {
        Integer[] res = new Integer[arr.length];
        if (arr.length > 1) {
            Integer[] half1 = half1(arr);
            Integer[] half2 = half2(arr);
            mergeSortMethod(half1, fh, log);
            mergeSortMethod(half2, fh, log);
            res = merge(half1, half2, arr);
            log.info(Arrays.toString(res));
        } else {
            res = arr.clone();
        }
        return res;
    }
    // выделение левой половины исходного массива
    private static Integer[] half1(Integer[] arr) {
        Integer[] half1 = new Integer[arr.length / 2];
        for (int i = 0; i < half1.length; i++) {
            half1[i] = arr[i];
        }
        return half1;
    }
    // выделение правой половины исходного массива
    private static Integer[] half2(Integer[] arr) {
        Integer[] half2 = new Integer[arr.length - (arr.length / 2)];
        for (int i = 0; i < half2.length; i++) {
            half2[i] = arr[arr.length / 2 + i];
        }
        return half2;
    }
    // слияние подмассивов в результирующий
    private static Integer[] merge(Integer[] half1, Integer[] half2, Integer[] arr) {
        /*
        Так как слияние может идти неравномерно, то заводим 2 счётчика,
        чтобы отслеживать крайний меньший элемент из половинок
        */
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < arr.length; i++) {
            // ЕСЛИ (вторая половина закончилась ИЛИ (первая половина еще не кончилась И 
            // элемент из первой половины меньше либо равен элементу из второй половины))
            // ТОГДА берем элементы из первой половины
            // ИНАЧЕ берем из второй половины
            if (i2 >= half2.length || (i1 < half1.length && half1[i1] <= half2[i2])) {
                arr[i] = half1[i1];
                i1++;
            } else {
                arr[i] = half2[i2];
                i2++;
            }
        }
        return arr;
    }
}

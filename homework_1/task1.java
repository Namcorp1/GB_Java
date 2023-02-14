package homework_1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        // Написать программу вычисления n-ого треугольного числа.
        // От себя решил добавить также проверку на то, является ли число треугольным.
        System.out.println("Посчитать треугольное число (1) или проверить число на треугольность (2)?");
        Scanner answer = new Scanner(System.in);
        System.out.print("Введите вариант задачи: ");
        int var = answer.nextInt();
        Scanner num_for_task = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = num_for_task.nextInt();
        if (var == 1) {
            System.out.println(triangle_number(num));
        } else if (var == 2) {
            System.out.println(check_triangle_number(num));
        } else {
            System.out.println("Такого варианта нету, до свидания!");
        }
    }

    private static int triangle_number(int num) {
        double double_result = 0.5 * num * (num + 1);
        int result = (int) double_result;
        return result;
    }

    private static boolean check_triangle_number(int num) {
        double check = Math.pow(8 * num + 1, 0.5) - 1;
        if (check % 2 == 0) {
            check /= 2;
            int n = (int) check;
            String res = String.format("Число является треугольным %d -> %d", num, n);
            System.out.println(res);
            return true;
        } else {
            String res = String.format("Число %d не является треугольным", num);
            System.out.println(res);
            return false;
        }
    }
}
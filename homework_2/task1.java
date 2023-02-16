package homework_2;

import java.util.Scanner;

/* Дана строка sql-запроса "select * from students where ".
Сформируйте часть WHERE этого запроса, используя StringBuilder.
Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: 
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} */

public class task1 {
    public static void main(String[] args) {
        String request = "select * from students where ";
        String[] options = { "name", "country", "city", "age" };
        String[] filter = filterOptions(options);
        System.out.println(createRequest(request, options, filter));
    }

    private static String[] filterOptions(String[] options) {
        String[] res = new String[options.length];
        for (int i = 0; i < options.length; i++) {
            Scanner inputData = new Scanner(System.in);
            String op = String.format("%s: ", options[i]);
            System.out.print(op);
            String data = inputData.next(); 
            res[i] = data;         
        }
        return res;
    }

    private static String createRequest(String request, String[] options, String[] filter) {
        StringBuilder sample = new StringBuilder();
        for (int i = 0; i < filter.length; i++) {
            if (!"null".equals(filter[i])) {
                sample.append(options[i]).append("=").append(filter[i]).append(" and ");
            }
        }
        sample.delete(sample.length() - 5, sample.length() - 1);
        String forRequest = sample.toString();
        request += forRequest;
        return request;
    }
}
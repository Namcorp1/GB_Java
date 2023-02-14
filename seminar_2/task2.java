package seminar_2;

public class task2 {
    public static void main(String[] args) {
        // Напишите метод, который сжимает строку. Пример: вход aaaabbbcdd.
        String input_string = "aaabbccccdee";
        System.out.println(coding_LRE(input_string));

    }

    public static String coding_LRE(String str) {

        StringBuilder result = new StringBuilder();
        int count_char = 1;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            while (i + 1 < chars.length && c == chars[i + 1]) {
                count_char++;
                i++;
            }
            result.append(count_char).append(c);
            count_char = 1;
        }

        return result.toString();
    }
}

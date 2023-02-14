package seminar_2;

public class Task1{
    public static void main(String[] args) {
        int num = 64;
        char sym1 = 'h';
        char sym2 = 'a';
        System.out.println(createString(num, sym1, sym2));
    }
    private static String createString(int num, char c1, char c2){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < num/2; i++){
            stringBuilder.append(c1).append(c2);
        }
        return stringBuilder.toString();
    }
}
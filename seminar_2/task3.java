package seminar_2;

public class Task3 {
    public static void main(String[] args) {
        String input_data = "шалаш";
        System.out.println(check_palindrom(input_data));
    }
    private static Boolean check_palindrom(String text){
        int point = text.length() / 2;
        for(int i = 0; i < point; i++){
            if(text.charAt(i) != text.charAt(text.length() - i)){
                return false;
            }
        }
        return true;
    }
}

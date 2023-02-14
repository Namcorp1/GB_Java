package seminar_2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.*;

public class task5 {
    public static void main(String[] args) {
        /*
         Напишите метод, который вернет содержимое текущей папки в виде массива строк.
         Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
         Обработайте ошибки с помощью try-catch конструкции.
         В случае возникновения исключения, оно должно записаться в лог-файл.
         */
        String[] files = stringFiles();
        //File output = new File(".");
        writeToFile(files);

    }
    public static String[] stringFiles(){
        File file = new File(".");
        String[] list = file.list();
        return list;
    }
    public static void writeToFile(String[] fileStrings){
        try {
            FileWriter fileWriter = new FileWriter("files.txt");
            for (String content : fileStrings) {
                fileWriter.write(content + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            // запись ошибки в лог-файл
            File logFile = new File("log.txt");
            FileWriter logWriter = new FileWriter(logFile, true);
            logWriter.write(e.getMessage());
            logWriter.close();
        }    
    }
}

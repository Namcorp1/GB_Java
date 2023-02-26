import java.io.File;

public class Labirint {
    Labirint(int[][] sample){
        this.sample = sample;
    }

    public static int[][] sample = {
            {-1,-1,-1,-1,-1,-1,-1,-1},
            {-1,0,0,0,0,-1,0,-1},
            {-1,-1,0,-1,0,0,0,-1},
            {-1,0,0,-1,-1,0,-1,-1},
            {-1,-1,0,0,0,0,0,-1},
            {-1,-1,0,-1,0,-1,-1,-1},
            {-1,0,0,-1,0,0,0,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1},
    };

    public static void printLabirint(int[][] sample){
        for(int i = 0; i < sample.length; i++){
            for(int j=0; j < sample[0].length; j++){
                if(sample[i][j] == -2 || sample[i][j] == sample.length * sample[0].length){
                    System.out.print("\033[32m" + sample[i][j] + "\033[0m ");
                }
                else if(sample[i][j] == -3){
                    System.out.print("\033[37m" + sample[i][j] + "\033[0m ");
                }
                else if(sample[i][j] < 0){
                    System.out.print("\033[31m" + sample[i][j] + "\033[0m ");
                }
                else if(sample[i][j] == 0){
                    System.out.print(" " + sample[i][j] + " ");
                }
                else if(sample[i][j] >= 10){
                    System.out.print("\033[34m" + sample[i][j] + "\033[0m ");
                }
                else if(sample[i][j] > 0){
                    System.out.print(" \033[34m" + sample[i][j] + "\033[0m ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

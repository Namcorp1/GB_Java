import java.io.File;

public class Labirint {
    Labirint(int[][] sample){
        this.sample = sample;
    }

    public static int[][] sample = {
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
            {-1, 0, 0, 0, 0,-1, 0,-1, 0, 0,-1},
            {-1, 0, 0, 0, 0,-1, 0,-1, 0, 0,-1},
            {-1, 0, 0, 0, 0,-1, 0,-1, 0, 0,-1},
            {-1,-1, 0, 0, 0, 0, 0, 0, 0, 0,-1},
            {-1, 0, 0,-1,-1, 0,-1, 0,-1,-1,-1},
            {-1,-1, 0, 0, 0, 0,-1, 0, 0, 0,-1},
            {-1,-1, 0,-1, 0, 0,-1,-1, 0, 0,-1},
            {-1, 0, 0,-1, 0, 0, 0, 0, 0, 0,-1},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
    };

    public static int[][] copyLabirint(int[][]sample){
        int[][] clone = new int[sample.length][sample[0].length];
        for(int i = 0; i < sample.length; i++){
            for(int j=0; j < sample[0].length; j++) {
                clone[i][j] = sample[i][j];
            }
        }
        return clone;
    }

    public static void printLabirint(int[][] sample){
        for(int i = 0; i < sample.length; i++){
            for(int j=0; j < sample[0].length; j++){
                if(sample[i][j] == -2){
                    //System.out.print("\033[32m" + sample[i][j] + "\033[0m ");
                    System.out.print("\u001B[44m" + " E " + "\u001B[0m");
                }
                else if(sample[i][j] == 1){
                    //System.out.print("\033[32m" + sample[i][j] + "\033[0m ");
                    System.out.print("\u001B[47m" + " S " + "\u001B[0m");
                }
                else if(sample[i][j] == sample.length * sample[0].length) {
                    //System.out.print("\033[32m" + sample[i][j] + "\033[0m ");
                    System.out.print("\u001B[42m" + " W " + "\u001B[0m");
                }
                else if(sample[i][j] == -3){
                    //System.out.print("\033[37m" + sample[i][j] + "\033[0m ");
                    System.out.print("\u001B[41m" + "   " + "\u001B[0m");
                }
                else if(sample[i][j] < 0){
                    //System.out.print("\033[31m" + sample[i][j] + "\033[0m ");
                    System.out.print("\u001B[46m" + "   " + "\u001B[0m");
                }
                else if(sample[i][j] == 0){
                    //System.out.print(" " + sample[i][j] + " ");
                    System.out.print("\u001B[40m" + "   " + "\u001B[0m");
                }
                else if(sample[i][j] >= 10){
                    //System.out.print("\033[34m" + sample[i][j] + "\033[0m ");
                    System.out.print("\u001B[43m" + " " + sample[i][j] + "\u001B[0m");
                }
                else if(sample[i][j] > 0){
                    //System.out.print(" \033[34m" + sample[i][j] + "\033[0m ");
                    System.out.print("\u001B[43m" + "  " +sample[i][j] + "\u001B[0m");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

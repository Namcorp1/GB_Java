import java.util.Random;

public class Point {
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int x;
    public int y;

    public static Point Marker(int[][] labirint){
        Point start = new Point(0,0);
        Random random = new Random();
        while(labirint[start.x][start.y] != 0){
            start.x = random.nextInt(1,labirint[0].length - 1);
            start.y = random.nextInt(1,labirint.length - 1);
        }
        return start;
    }

}

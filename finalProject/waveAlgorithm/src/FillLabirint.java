import java.util.LinkedList;
import java.util.Queue;

public class FillLabirint {

    FillLabirint(Point startPoint,Point endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point startPoint;
    public Point endPoint;

    public static void Algorithm(int[][] labirint, Point startPoint){
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(startPoint);
        while (queue.size() != 0) {
            Point check = queue.remove();
            if (labirint[check.x - 1][check.y] == 0) {
                queue.add(new Point(check.x - 1, check.y));
                labirint[check.x - 1][check.y] = labirint[check.x][check.y] + 1;
            }
            if (labirint[check.x][check.y + 1] == 0) {
                queue.add(new Point(check.x, check.y + 1));
                labirint[check.x][check.y + 1] = labirint[check.x][check.y] + 1;
            }
            if (labirint[check.x + 1][check.y] == 0) {
                queue.add(new Point(check.x + 1, check.y));
                labirint[check.x + 1][check.y] = labirint[check.x][check.y] + 1;
            }
            if (labirint[check.x][check.y - 1] == 0) {
                queue.add(new Point(check.x, check.y - 1));
                labirint[check.x][check.y - 1] = labirint[check.x][check.y] + 1;
            }
        }
    }


}

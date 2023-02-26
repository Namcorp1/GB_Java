import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Way {

    public Way(Point endPoint){
        this.endPoint = endPoint;
    }

    public Point endPoint;

    public static int FindWay(int[][] labirint, Point endPoint){
        int lengthWay = 0;
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(endPoint);
        labirint[queue.element().x][queue.element().y] = labirint.length * labirint[0].length;
        while(labirint[queue.element().x][queue.element().y] != 1) {
            if (labirint[queue.element().x - 1][queue.element().y] > 0) {
                if (labirint[queue.element().x][queue.element().y] > labirint[queue.element().x - 1][queue.element().y]) {
                    queue.add(new Point(queue.element().x - 1, queue.element().y));
                    queue.remove();
                }
            }
            if (labirint[queue.element().x][queue.element().y + 1] > 0) {
                if (labirint[queue.element().x][queue.element().y] > labirint[queue.element().x][queue.element().y + 1]) {
                    queue.add(new Point(queue.element().x, queue.element().y + 1));
                    queue.remove();
                }
            }
            if (labirint[queue.element().x + 1][queue.element().y] > 0) {
                if (labirint[queue.element().x][queue.element().y] > labirint[queue.element().x + 1][queue.element().y]) {
                    queue.add(new Point(queue.element().x + 1, queue.element().y));
                    queue.remove();
                }
            }
            if (labirint[queue.element().x][queue.element().y - 1] > 0) {
                if (labirint[queue.element().x][queue.element().y] > labirint[queue.element().x][queue.element().y - 1]) {
                    queue.add(new Point(queue.element().x, queue.element().y - 1));
                    queue.remove();
                }
            }
            lengthWay ++;
        }
        return lengthWay;
    }
}

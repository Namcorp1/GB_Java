import java.util.*;

public class Way {

    public Way(Point endPoint){
        this.endPoint = endPoint;
    }

    public Point endPoint;

    public static void FindWay(int[][] labirint, int[][] forPrint, Point endPoint){
        int lengthWay = 0;
        TreeMap<Integer,Point> points = new TreeMap<>();
        labirint[endPoint.x][endPoint.y] = labirint.length * labirint[0].length;
        forPrint[endPoint.x][endPoint.y] = -2;
        while(labirint[endPoint.x][endPoint.y] != 1) {
            if (labirint[endPoint.x - 1][endPoint.y] > 0) {
                points.put(labirint[endPoint.x - 1][endPoint.y],new Point(endPoint.x - 1,endPoint.y));
            }
            if (labirint[endPoint.x][endPoint.y + 1] > 0) {
                points.put(labirint[endPoint.x][endPoint.y + 1],new Point(endPoint.x,endPoint.y + 1));
            }
            if (labirint[endPoint.x + 1][endPoint.y] > 0) {
                points.put(labirint[endPoint.x + 1][endPoint.y],new Point(endPoint.x + 1,endPoint.y));
            }
            if (labirint[endPoint.x][endPoint.y - 1] > 0) {
                points.put(labirint[endPoint.x][endPoint.y - 1],new Point(endPoint.x,endPoint.y - 1));
            }
            Point nextPoint = points.firstEntry().getValue();
            endPoint = new Point(nextPoint.x,nextPoint.y);
            forPrint[endPoint.x][endPoint.y] = labirint.length * labirint[0].length;
            lengthWay++;
        }
        forPrint[endPoint.x][endPoint.y] = 1;
        System.out.println("Количество шагов равно " + lengthWay);
        System.out.println();
    }

    public static void FindWay2(int[][] labirint, int[][] forPrint, Point endPoint){
        int lengthWay = 0;
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(endPoint);
        HashMap<Point,Integer> points = new HashMap<>();
        points.put(new Point(queue.element().x-1,queue.element().y),labirint[queue.element().x-1][queue.element().y]);
        points.put(new Point(queue.element().x,queue.element().y+1),labirint[queue.element().x][queue.element().y+1]);
        points.put(new Point(queue.element().x+1,queue.element().y),labirint[queue.element().x+1][queue.element().y]);
        points.put(new Point(queue.element().x,queue.element().y-1),labirint[queue.element().x][queue.element().y-1]);
    }
}


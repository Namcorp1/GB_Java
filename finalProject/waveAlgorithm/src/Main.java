public class Main {
    public static void main(String[] args) {
        Labirint labirint = new Labirint(Labirint.sample);
        Labirint.printLabirint(Labirint.sample);
        Point startPoint = Point.Marker(Labirint.sample);
        Point finishPoint = Point.Marker(Labirint.sample);
//        Point startPoint = new Point(1,1);
//        Point finishPoint = new Point(5,4);
        FillLabirint fillLabirint = new FillLabirint(startPoint,finishPoint);
        Labirint.sample[startPoint.x][startPoint.y] += 1;
        Labirint.sample[finishPoint.x][finishPoint.y] -= 2;
        Labirint.printLabirint(Labirint.sample);
        FillLabirint.Algorithm(Labirint.sample,fillLabirint.startPoint);
        Labirint.printLabirint(Labirint.sample);
        int result = Way.FindWay(Labirint.sample,fillLabirint.endPoint);
        Labirint.printLabirint(Labirint.sample);
        System.out.println("Длина пути равна " + result);
    }
}
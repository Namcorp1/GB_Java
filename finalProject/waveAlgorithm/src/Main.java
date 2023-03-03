public class Main {
    public static void main(String[] args) {
        Labirint labirint = new Labirint(Labirint.sample);
        int[][] solution = Labirint.copyLabirint(Labirint.sample);
        Labirint.printLabirint(Labirint.sample);
        Point startPoint = Point.Marker(Labirint.sample);
        Point finishPoint = Point.Marker(Labirint.sample);
        FillLabirint fillLabirint = new FillLabirint(startPoint,finishPoint);
        solution[startPoint.x][startPoint.y] += 1;
        solution[finishPoint.x][finishPoint.y] -= 2;
        Labirint.printLabirint(solution);
        FillLabirint.Algorithm(solution,fillLabirint.startPoint);
        Labirint.printLabirint(solution);
        Way.FindWay(solution,Labirint.sample,fillLabirint.endPoint);
        Labirint.printLabirint(Labirint.sample);
    }
}
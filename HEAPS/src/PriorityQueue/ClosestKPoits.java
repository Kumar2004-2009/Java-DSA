package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ClosestKPoits {
    private static class Point{
        int x;
        int y;
        int distance;
    }

    private static class PointComparator implements Comparator<Point>{
        public int compare(Point p1,Point p2){
            if(p1.distance>p2.distance) return 1;

            else if(p1.distance<p2.distance) return -1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Point> pointPriorityQueue=new PriorityQueue<>(new PointComparator());

    }
}

package Math;

import java.util.Scanner;

class Point{
    long x, y;
    Point(long x, long y){
        this.x = x;
        this.y = y;
    }
}
class Line{
    Point first, second;
    Line(Point first, Point second){
        this.first = first;
        this.second = second;
    }
}

public class IntersectionOfTwoLine1_17386 {
    static int ccw(Point p1, Point p2, Point p3){
        long x1 = p1.x; long y1 = p1.y;
        long x2 = p2.x; long y2 = p2.y;
        long x3 = p3.x; long y3 = p3.y;

        long temp = x1*y2+x2*y3+x3*y1;
        temp = temp - (x2*y1+x3*y2+x1*y3);
        if(temp < 0) return 1;
        else if(temp > 0) return -1;
        else return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x1 = sc.nextLong();
        long y1 = sc.nextLong();
        long x2 = sc.nextLong();
        long y2 = sc.nextLong();
        long x3 = sc.nextLong();
        long y3 = sc.nextLong();
        long x4 = sc.nextLong();
        long y4 = sc.nextLong();

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        Point p3 = new Point(x3, y3);
        Point p4 = new Point(x4, y4);

        int res1 = ccw(p1, p2, p3) * ccw(p1, p2, p4);
        int res2 = ccw(p3, p4, p1) * ccw(p3, p4, p2);
        if(res1 < 0 && res2 < 0){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}

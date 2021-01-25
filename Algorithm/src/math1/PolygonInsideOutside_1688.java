package Math;

import java.util.Scanner;

class Point3{
    long x, y;
    Point3(long x, long y){
        this.x = x;
        this.y = y;
    }
}

class Line3{
    Point3 first, second;
    Line3(Point3 first, Point3 second){
        this.first = first;
        this.second = second;
    }
}

public class PolygonInsideOutside_1688 {
    static int ccw(Point3 p1, Point3 p2, Point3 p3){
        long temp = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y;
        temp -= p2.x * p1.y + p3.x * p2.y + p1.x * p3.y;
        if(temp > 0) return 1;
        if(temp < 0) return -1;
        return 0;
    }
    static int cross(Line3 l1, Line3 l2){
        int l1l2 = ccw(l1.first, l1.second, l2.first) * ccw(l1.first, l1.second, l2.second);
        int l2l1 = ccw(l2.first, l2.second, l1.first) * ccw(l2.first, l2.second, l1.second);
        return l1l2 < 0 && l2l1 < 0 ? 1 : 0;
    }
    static int go(Point3 p, int n, Point3[] a){
        for(int i=0; i<n; i++){
            int temp = ccw(a[i], p, a[i+1]);
            if(temp == 0){
                long minx = Math.min(a[i].x, a[i+1].x);
                long maxx = Math.max(a[i].x, a[i+1].x);
                long miny = Math.min(a[i].y, a[i+1].y);
                long maxy = Math.max(a[i].y, a[i+1].y);
                if(minx <= p.x && p.x <= maxx){
                    if(miny <= p.y && p.y <= maxy){
                        return 1;
                    }
                }
            }
        }

        Point3 p0 = new Point3(1, 2147483647);
        Line3 l0 = new Line3(p, p0);
        int cnt = 0;
        for(int i=0; i<n; i++){
            Line3 l = new Line3(a[i], a[i+1]);
            cnt += cross(l0, l);
        }

        return cnt%2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point3[] a = new Point3[n + 1];
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[i] = new Point3(x, y);
        }
        a[n] = a[0];
        int m = 3;
        while (m-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            Point3 p = new Point3(x, y);
            System.out.println(go(p, n, a));
        }
    }
}

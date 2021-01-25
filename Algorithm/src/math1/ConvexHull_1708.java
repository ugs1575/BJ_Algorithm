package Math;

import java.util.*;

class Point4{
    long x, y;
    Point4(long x, long y){
        this.x = x;
        this.y = y;
    }
}

public class ConvexHull_1708 {
    static long dist(Point4 p1, Point4 p2){
        long d1 = (long)(p1.x-p2.x);
        long d2 = (long)(p1.y-p2.y);
        return d1*d1 + d2*d2;
    }
    static int ccw(Point4 p1, Point4 p2, Point4 p3){
        long temp = p1.x*p2.y+p2.x*p3.y+p3.x*p1.y;
        temp -= p2.x*p1.y+p3.x*p2.y+p1.x*p3.y;
        if(temp > 0) return 1;
        if(temp < 0) return -1;
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point4[] a = new Point4[n];
        for(int i=0; i<n; i++){
            long x = sc.nextLong();
            long y = sc.nextLong();
            a[i] = new Point4(x, y);
        }

        Point4 p = a[0];
        for(int i=1; i<n; i++){
            if(a[i].y < p.y || (a[i].y == p.y && a[i].x < p.x)){
                p = a[i];
            }
        }

        final Point4 pp = p;
        Arrays.sort(a, new Comparator<Point4>() {
            @Override
            public int compare(Point4 u, Point4 v) {
                int res = ccw(pp, u, v);
                if(res == 0){
                    long d1 = dist(pp, u);
                    long d2 = dist(pp, v);
                    if(d1 < d2) return -1;
                    else if(d1 > d2) return 1;
                    else return 0;
                }else{
                    if(res == 1) return -1;
                    else return 1;
                }
            }
        });

        ArrayList<Point4> stack = new ArrayList<Point4>();
        for(int i=0; i<n; i++){
            int size = stack.size();
            while (size >= 2 && ccw(stack.get(size-2), stack.get(size-1), a[i]) <= 0){
                stack.remove(size-1);
                size -= 1;
            }
            stack.add(a[i]);
        }
        System.out.println(stack.size());




    }
}

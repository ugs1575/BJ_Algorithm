/*
* 한 점(p)을 기준으로 각 p.x, p.y 좌표에서 최단 거리(d)를 - + 영역에 존재하는 후보들을 추출한다.
* 1. x 값이 증가하는 순으로 정렬한다.
* 2. 두 점(array[0], array[1]) 사이의 거리를 최단 거리라고 가정한다.
* 3. x축의 차이가 최단 거리보다 크다면 비교할 필요가 없기에 후보자를 걸러준다.
* 4. y축을 기준으로 정렬된 후보자들을 통해 최단 거리를 갱신하게 된다.
* 4번의 과정인 최단 거리를 갱신하기 위한 과정에 있어, 후보자들 사이에서 (y - d) ~ (y + d) 영역을 구해야한다.
*
* 참조: https://mygumi.tistory.com/294 [마이구미의 HelloWorld]
* */

package Math;

import java.io.*;
import java.util.*;

class Point5{
    int x, y;
    Point5(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class PointComparatorX implements Comparator<Point5>{
    @Override
    public int compare(Point5 u, Point5 v) {
        if(u.x < v.x){
            return -1;
        }else if(u.x == v.x){
            if(u.y < v.y){
                return -1;
            }else if(u.y == v.y){
                return 0;
            }else{
                return 1;
            }
        }else{
            return 1;
        }
    }
}
class PointComparatorY implements Comparator<Point5>{

    @Override
    public int compare(Point5 u, Point5 v) {
        if(u.y < v.y){
            return -1;
        }else if(u.y == v.y){
            if(u.x < v.x){
                return -1;
            }else if(u.x == v.x){
                return 0;
            }else{
                return 1;
            }
        }else{
            return 1;
        }
    }
}

public class CloestPair_Line_Sweep_2261 {
    static int dist(Point5 p1, Point5 p2){
        return (p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Point5[] a = new Point5[n];
        for(int i=0; i<n; i++){
            String[] line = bf.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            a[i] = new Point5(x, y);
        }
        Arrays.sort(a, new PointComparatorX()); //x축을 기준으로 정렬
        PointComparatorY cmp = new PointComparatorY();
        //y축을 기준으로 후보 유지
        //candidate : 마지막점과 거리차이가 d이하
        TreeSet<Point5> candidate = new TreeSet<>(cmp);
        candidate.add(a[0]);
        candidate.add(a[1]);
        //d : 가장 가까운 거리
        //일단 d = 1,2번째 거리 사이로 정해준다.
        int ans = dist(a[0], a[1]);
        int start = 0;
        for(int i=2; i<n; i++){
            Point5 now = a[i];
            while (start < i){
                Point5 p = a[start];
                int x = now.x - p.x;
                //d이상이 되면 후보자에서 제외해준다. x축을 기준으로 정렬이 되어있기 때문에
                //그 뒤로 어떤 점이 들어온다고 해도, d이상이기 때문에 제외해도 됨.
                if(x*x > ans){
                    candidate.remove(p);
                    start += 1;
                }else{
                    break;
                }
            }
            int diff = (int) (Math.sqrt((double)ans)+1);
            Point5 lower_point = new Point5(-100000, now.y-diff);
            Point5 upper_point = new Point5(100000, now.y+diff);
            Point5 p = candidate.ceiling(lower_point); //같거나 큰것중에 가장 작은 것 return
            while (p != null && cmp.compare(p, upper_point) != 1){ //최대 6번 돈다.
                int d = dist(now, p);
                if(d < ans){
                    ans = d;
                }
                // ceiling 으로 하면 자기자신을 return 시켜서 while문을 빠져나오지 못한다.
                // 큰것중에 가장 작은 것 return
                p = candidate.ceiling(p);
            }
            candidate.add(now);
        }
        System.out.println(ans);
    }
}

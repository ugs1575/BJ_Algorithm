/*
*
*
* 우선 두 도시가 좌표계 위에 있기 때문에 두 점 사이의 최단거리는 무조건 직선이다.
* 다만 텔레포트가 있기 때문에 텔레포트를 한 번 이용할 경우에만 더 짧은 거리가 나올 수 있다.
* 따라서 다음과 같이 경우를 나눌 수 있다.
*
* 출발점과 도착점이 텔레포트가 가능한 경우
* 출발점과 도착점의 직선 거리 소요 시간과 텔레포트 소요 시간을 비교한다.
*
* 출발점만 텔레포트 가능 도시일 경우
* 도착점과 가장 가까운 텔레포트 가능 도시를 찾는다.
* 그러면 텔레포트 시간 + 가장 가까운 도시에서 도착점까지의 직선 거리 소요 시간과 출발점과 도착점의 직선 거리 소요 시간을 비교한다.
*
* 도착점만 텔레포트 가능 도시일 경우
* 출발점과 가장 가까운 텔레포트 가능 도시를 찾는다.
* 그러면 텔레포트 시간 + 가장 가까운 도시에서 출발점까지의 직선 거리 소요 시간과 출발점과 도착점의 직선 거리 소요 시간을 비교한다.
*
* 출발점과 도착점이 둘다 텔레포트가 불가한 경우
* 출발점, 도착점과 가장 가까운 텔레포트 가능 도시를 각각 찾는다.
* 텔레포트 시간 + 각 지점과 찾은 도시 사이의 직선 거리 소요 시간과 출발점과 도착점의 직선 거리 소요 시간을 비교한다.
*
* 총 네가지의 경우를 바탕으로 최단거리를 출력한다.
*
*
* */

package bruteforce.etc;

import java.util.ArrayList;
import java.util.Scanner;

class Pair9{
    boolean s;
    int x, y;
    Pair9(boolean s, int x, int y){
        this.s = s;
        this.x = x;
        this.y = y;
    }
}
public class Teleport_16958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        Pair9[] a = new Pair9[n+1];

        ArrayList<Integer> tcity = new ArrayList<>();
        for(int i=1; i<=n; i++){
            int s = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            boolean specialCity = false;
            if(s == 1){
                specialCity = true;
                tcity.add(i);
            }
            a[i] = new Pair9(specialCity, x, y);
        }

        int[][] time = new int[1001][1001];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                int k = Math.abs(a[i].x - a[j].x) + Math.abs(a[i].y - a[j].y);
                time[i][j] = k;
                time[j][i] = k;
            }
        }

        int m = sc.nextInt();
        int[] ans = new int[m];
        for(int i=0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            if(a[from].s && a[to].s){
                ans[i] = Math.min(t, time[from][to]);
            }else if(!a[from].s && !a[to].s){
                int min = time[from][to];
                int fromc = Integer.MAX_VALUE;
                int toc = Integer.MAX_VALUE;
                for(int j=0; j<tcity.size(); j++){
                    int c = tcity.get(j);
                    if(time[from][c] < fromc){
                        fromc = time[from][c];
                    }

                    if(time[to][c] < toc){
                        toc = time[to][c];
                    }
                }
                ans[i] = Math.min(min, fromc+t+toc);
            }else{
                int min = time[from][to];
                for(int j=0; j<tcity.size(); j++){
                    int c = tcity.get(j);
                    if(a[from].s){
                        if(c != from && time[c][to]+t < min){
                            min = time[c][to]+t;
                        }
                    }else{
                        if(c != to && time[from][c]+t < min){
                            min = time[from][c]+t;
                        }
                    }
                }
                ans[i] = min;
            }
        }

        for(int i:ans){
            System.out.println(i);
        }

    }
}

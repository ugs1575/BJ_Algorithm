/*
* 메모리초과 : bfs 방문 여부 체크할때, pop할때 체크하지 말고 큐에 넣을 때 체크하기
* 시간초과 : 불필요하게 시작지점에서 for문돌아서 pair로 해서 큐에 넣어주고 있었음, 섬번호만 집어넣어주고 바로 bfs함수 호출함
*
*
* */

package divideConquer.binarySearch;

import java.util.*;
import java.io.*;

class Pair{
    int b, c;
    Pair(int b, int c){
        this.b = b;
        this.c = c;
    }
}

public class Limit_1939 {
    static boolean[] check;
    static ArrayList<Pair>[] a;
    static Queue<Integer> q = new LinkedList<>();
    static int start, end;
    static boolean bfs(int limit){
        while (!q.isEmpty()){
            int island = q.remove();
            for(int i=0; i<a[island].size(); i++){
                Pair p2 = a[island].get(i);
                if(p2.c >= limit && !check[p2.b]) {
                    check[p2.b] = true;
                    q.add(p2.b);
                }
            }

        }
        //System.out.println(limit+"/"+check[end]);
        return check[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        a = new ArrayList[n+1];
        check = new boolean[n+1];

        for(int i=0; i<=n; i++){
            a[i] = new ArrayList<Pair>();
        }

        for(int i=0; i<m; i++){
            s = br.readLine().split(" ");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);
            int limit = Integer.parseInt(s[2]);
            a[from].add(new Pair(to, limit));
            a[to].add(new Pair(from, limit));
        }
        s = br.readLine().split(" ");
        start = Integer.parseInt(s[0]);
        end = Integer.parseInt(s[1]);

        int left = 1;
        int right = 1000000000;
        int ans = 0;
        while (left <= right){
            int mid = (left+right)/2;
            Arrays.fill(check,false);
            check[start] = true;
            q.add(start);

            if(bfs(mid)){
                ans = Math.max(ans, mid);
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        System.out.println(ans);




    }
}

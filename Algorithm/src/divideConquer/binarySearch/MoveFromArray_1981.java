/*
*
* 이진 탐색의 지표는 이진 탐색으로 정한 최대-최소 차이 내로 (1, 1)에서 (n, n)으로 갈 수 있느냐
* (1, 1) -> (n, n) 갈 수 있느냐는 bfs로 탐색
*
* */

package divideConquer.binarySearch;

import java.io.*;
import java.util.*;

class Pair2{
    int x, y;
    Pair2(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class MoveFromArray_1981 {
    static int n;
    static int[][] a;
    static boolean[][] check;
    static int[] ax = {1,-1,0,0};
    static int[] ay = {0,0,1,-1};
    static boolean bfs(int mn, int mx){
        if(mn > a[0][0] || mx < a[0][0]){
            return false;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                check[i][j] = false;
            }
        }

        Queue<Pair2> q = new LinkedList<Pair2>();
        check[0][0] = true;
        q.add(new Pair2(0,0));
        while (!q.isEmpty()){
            Pair2 p = q.remove();
            for(int i=0; i<4; i++){
                int nx = p.x+ax[i];
                int ny = p.y+ay[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(!check[nx][ny]){
                    if(mn <= a[nx][ny] && a[nx][ny] <= mx){
                        check[nx][ny] = true;
                        q.add(new Pair2(nx, ny));
                    }
                }
            }
        }

        return check[n-1][n-1];
    }

    static boolean go(int diff){
        for(int mn=0; mn+diff<=200; mn++){
            if(bfs(mn, mn+diff)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        check = new boolean[n][n];
        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                a[i][j] = Integer.parseInt(s[j]);
            }
        }

        int left  = 0;
        int right = 200;
        int ans = 200;
        while (left <= right){
            int mid = (left+right)/2;
            if(go(mid)){
                ans = Math.min(ans, mid);
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(ans);
    }
}

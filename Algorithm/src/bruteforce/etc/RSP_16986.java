package bruteforce.etc;

import java.io.*;
import java.util.*;

public class RSP_16986 {
    static int n, k;
    static int[][] a;
    static int[] gh, mh;
    static boolean play(int p1, int p2, int cnt, int gw_idx, int gh_idx, int mh_idx, int[] gw, int[] win){
        boolean ans = false;
        if(win[0] == k) return true;
        if(win[1] == k || win[2] == k) return false;
        if(gw_idx == n) return false;

        int temp1 = p1;
        int temp2 = p2;
        int h1 = 0;
        int h2 = 0;
        if(p1 == 0){ //지우이면
            h1 = gw[gw_idx++];
        }else if(p1 == 1) {//경희이면
            h1 = gh[gh_idx++];
        }else{
            h1 = mh[mh_idx++];//민호이면
        }

        if(p2 == 0){ //지우이면
            h2 = gw[gw_idx++];
        }else if(p2 == 1) {//경희이면
            h2 = gh[gh_idx++];
        }else{
            h2 = mh[mh_idx++];//민호이면
        }

        if(a[h1][h2] == 2 || a[h1][h2] == 1 && p1 > p2){
            win[p1] += 1;
        }else{
            win[p2] += 1;
            p1 = p2;
        }
        while (true){
            p2 += 1;
            if(p2 == 3){
                p2 = 0;
            }
            if(p1 != p2 && p2 != temp2 && p2 != temp1){
                break;
            }
        }

        boolean res =  play(p1, p2, cnt+1, gw_idx, gh_idx, mh_idx, gw, win);
        if(res) ans = res;

        return ans;

    }
    static boolean go(int index, int[] gw, boolean[] check){
        boolean ans = false;
        if(index == n){
            int[] win = new int[3]; //0:지우, 1:경희, 2:민호
            boolean res = play(0, 1, 0, 0,0,0, gw, win);
            return res;
        }
        for(int i=1; i<=n; i++){
            if(check[i]) continue;
            gw[index] = i;
            check[i] = true;
            boolean res = go(index+1, gw, check);
            if(res) ans = res;
            check[i] = false;
        }

        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        a = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            s = br.readLine().split(" ");
            for(int j=1; j<=n; j++){
                a[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        gh = new int[20];
        s = br.readLine().split(" ");
        for(int i=0; i<20; i++){
            gh[i] = Integer.parseInt(s[i]);
        }

        mh = new int[20];
        s = br.readLine().split(" ");
        for(int i=0; i<20; i++){
            mh[i] = Integer.parseInt(s[i]);
        }

        int[] gw = new int[n];
        boolean[] check = new boolean[n+1];
        int ans = 0;
        if(go(0, gw, check)){
            ans = 1;
        }

        System.out.println(ans);

    }
}

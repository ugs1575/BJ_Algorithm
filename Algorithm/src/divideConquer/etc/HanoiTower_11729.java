package divideConquer.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HanoiTower_11729 {
    public static void solve(int n, int x, int y, StringBuilder sb){
        if(n == 0) return;
        solve(n-1, x, 6-x-y, sb);
        sb.append(x+" "+y+"\n");
        solve(n-1, 6-x-y, y, sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        System.out.println((1<<n)-1); //하노이탑 이동 최소횟수 2^n-1
        StringBuilder sb = new StringBuilder();
        solve(n, 1, 3, sb);
        System.out.println(sb);
    }
}

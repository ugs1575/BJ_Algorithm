package divideConquer.etc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Paper_1780 {
    public static boolean same(int[][] arr, int x, int y, int n){
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(arr[x][y] != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void solve(int[][] arr, int[] ans, int x, int y, int n){
        if(same(arr, x, y, n)){
            ans[arr[x][y]+1] += 1;
            return;
        }

        int m = n/3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                solve(arr, ans, x+i*m, y+j*m, m);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[][] arr = new int[n][n];
        int[] ans = new int[3];

        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.valueOf(s[j]);
            }
        }

        solve(arr, ans, 0, 0, n);

        for(int i=0; i<3; i++){
            System.out.println(ans[i]);
        }

    }
}

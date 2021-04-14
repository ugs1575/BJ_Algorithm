/*
* D[i][j] = i까지 수를 사용해서 j를 만드는 방법의 수
* D[i][j] = D[i-1][j-A[i]] + D[i-1][j+A[i]]
*
* A1 +- A2 ... +- Ai-1 + Ai = j
* |___D[i-1][j-A[i]]__|
 *
* A1 +- A2 ... +- Ai-1 - Ai = j
* |___D[i-1][j+A[i]]__|
*
* */


package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstYear_5557 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(s[i]);
        }
        int m = 20;
        long[][] d = new long[n][m+1];

        d[0][a[0]] = 1;
        for(int i=1; i<n-1; i++){
            for(int j=0; j<=m; j++){
                if(j-a[i] >= 0){
                    d[i][j] += d[i-1][j-a[i]];
                }

                if(j+a[i] <= m){
                    d[i][j] += d[i-1][j+a[i]];
                }
            }
        }

        System.out.println(d[n-2][a[n-1]]);


    }

}

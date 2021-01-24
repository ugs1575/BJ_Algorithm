/*
* 항상 최종 합치는 비용은 같고 (모든 파일의 합)
* 중간과정이 어떻게 되느냐에 따라서 값이 바뀌게 된다.
*
* 파일이 5개 있다고 하자. A1, A2, A3, A4, A5
* 이렇게 5개의 파일을 합치는 방법은 4가지가 있다.
* (A1) (A2, A3, A4, A5) -> (1,1),(2,5)
* (A1, A2) (A3, A4, A5) -> (1,2),(3,5)
* (A1, A2, A3) (A4, A5) -> (1,3),(4,5)
* (A1, A2, A3, A4) (A5) -> (1,4),(5,5)
*
* 파일의 시작위치와 끝위치를 활용한다.
* D[i][j] = i번 파일부터 j번 파일까지 합치는 최소비용
*
* (i ...... k )(....... j)
* k는 어디가 최소인지 모름 -> 다해보면 된다.
*
* (i ...... k ) -> D[i][k]
*           +
* (....... j)   -> D[k+1][j]
*           +
*   i~j 까지의 파일 합
*  이렇게 세가지를 합친것이 최소가 되는 경우를 D[i][j]에 넣어주면 된다
*  = D[i][j] = min(D[i][k] + D[k+1][j] + i~j까지의 파일 합)
*
* 여기서 k의 범위는
* i <= k < j
*
* */

package dynamicProgramming;

import java.io.*;
import java.util.*;

public class CombiningFile_11066 {
    static int[] a;
    static int[][] d;
    public static int go(int i, int j){
        if(i == j){ //파일을 합칠 필요가 없다
            return 0;
        }

        if(d[i][j] != -1){
            return d[i][j];
        }

        int ans = -1;
        int sum = 0;
        for(int k=i; k<=j; k++){
            sum += a[k];
        }

        for(int k=i; k<=j-1; k++){
            int temp = go(i, k)+go(k+1, j)+sum;
            if(ans == -1 || ans > temp){
                ans = temp;
            }
        }
        d[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            int n = Integer.valueOf(br.readLine());
            String[] nums = br.readLine().split(" ");
            a = new int[n+1];
            d = new int[n+1][n+1];
            for(int i=1; i<=n; i++){
                a[i] = Integer.valueOf(nums[i-1]);
                Arrays.fill(d[i], -1);
            }

            System.out.println(go(1, n));
        }
    }
}

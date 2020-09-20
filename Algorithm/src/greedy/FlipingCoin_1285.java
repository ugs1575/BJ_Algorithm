/*
* 각각의 칸을 바꿀 수 있는 방법은 모두 두가지 이다.
* 2 2 2
* 2 2 2
* 2 2 2
* 첫번째 행을 어떻게 할지 정하면
* 1 1 1
* 2 2 2
* 2 2 2
* 열에 대한 방법을 고려할 수 없다
* 제한이 20으로 작으므로 모든 행에 대해서 어떻게 할지 정한다 (2^n)
* 1 1 1
* 1 1 1
* 1 1 1
* 열에 대해서는 T가 적은 쪽으로 결정되어 버린다 (N^2)
* 총 시간 복잡도 2^n * N^2
*
* */

package greedy;

import java.util.Scanner;

public class FlipingCoin_1285 {
    static char flip(char x){
        if(x == 'T'){
            return 'H';
        }else{
            return 'T';
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] a = new char[n][n];
        for(int i=0; i<n; i++){
            String str = sc.next();
            for(int j=0; j<n; j++){
                a[i][j] = str.charAt(j);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<(1 << n); i++){
            int sum = 0;
            for(int j=0; j<n; j++){
                int cnt = 0;
                for(int k=0; k<n; k++){
                    char state = a[k][j];
                    if((k & (1 << i)) != 0){
                        state = flip(state);
                    }

                    if(state == 'T'){
                        cnt += 1;
                    }
                }
                sum += Math.min(cnt, n-cnt);
            }
            ans = Math.min(sum, ans);
        }

        System.out.println(ans);
    }

}

/*
* D[i] = 크리보드의 버튼을 총 i번 눌러서 화면에 출력된 A개수의 최대값
* 화면에 A를 출력하는 버튼을 누른 경우 : D[i-1]+1
* 마지막에 Ctrl+A, Ctrl+C, Ctrl+V를 누른 경우 : D[i-3]*2
* 마지막에 Ctrl+A, Ctrl+C, Ctrl+V, Ctrl+V를 누른 경우 : D[i-4]*3
* 마지막에 Ctrl+A, Ctrl+C, Ctrl+V, Ctrl+V, Ctrl+V를 누른 경우 : D[i-5]*4
*
* 일반화 해보면
* 마지막에 Ctrl+A, Ctrl+C를 누르고 Ctrl+V를 j번 누른 경우 : D[i(j+2)]*(j+1)
*
* D[i] = max(D[i-1]+1, D[i-(j+2)]*(j+1)) (1 <= j <= i-3)
*
* */


package dynamicProgramming;

import java.util.Scanner;

public class KriiiBoard_11058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] d = new long[n+1];
        for(int i=1; i<=n; i++){
            d[i] = d[i-1]+1;
            for(int j=1; j<=i-3; j++){
                long cur = d[i-j-2]*(j+1);
                if(cur > d[i]){
                    d[i] = cur;
                }
            }
        }
        System.out.println(d[n]);
    }
}

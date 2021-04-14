/*
 * 만들 수 있는 괄호 문자열의 개수를 구하는 문제
 * (?([?)]?}? -> 3
 * D[i][j] = i~j 까지 문자열을 이용해서 만들 수 있는 올바른 괄 문자열의 개수
 *
 *
 *       (  올바른 괄호 문자열  ) 올바른 괄호 문자열
 *       i                 k              j
 *       |_________________|______________|
 *           길이 i-2             길이 N-i
 *
 * i번째는 여는 괄호가 와야한다.
 * ?, (, [, { 가 올 수 있다.
 *
 * k가 i번째 괄호와 대응 하는 위치 라고 한다면
 * ( -> k번째에 ),? 가 올 수 있다.
 * [ -> ],?
 * { -> },?
 *
 * (i+1,k-1)와 (k+1,j)로 나눌 수 있다.
 * D[i][j] += D[i+1][k-1]*D[k+1][j]
 *
 * 주의해야할 조건
 * 1. k는 짝수
 * 2. 2 <= k <= L
 *
 *
 *
 *
 *
 * * */

package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Bracket2_3012 {
    static int n;
    static String s;
    static long[][] d = new long[200][200];
    static final long mod = 100000;
    static char[] open = {'(','{','['};
    static char[] close = {')','}',']'};
    static long go(int i, int j){
        if(i > j) return 1;
        long ans = d[i][j];
        if(ans != -1) return ans;
        ans = 0;
        for(int k=i+1; k<=j; k+=2){
            for(int l=0; l<3; l++){
                if(s.charAt(i) == open[l] || s.charAt(i) == '?'){
                    if(s.charAt(k) == close[l] || s.charAt(k) == '?'){
                        long temp = go(i+1, k-1) * go(k+1, j);
                        ans += temp;
                        if(ans >= mod){
                            ans = mod + ans % mod;
                        }
                    }
                }
            }
        }
        d[i][j] = ans;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.next();
        for(int i=0; i<200; i++){
            Arrays.fill(d[i],-1);
        }
        long ans = go(0, n-1);
        if(ans >= mod){
            System.out.printf("%05d\n", ans%mod);
        }else{
            System.out.println(ans);
        }
    }
}

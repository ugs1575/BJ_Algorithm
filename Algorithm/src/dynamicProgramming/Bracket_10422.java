/*
* ## Solution 1 (일차원 배열 사용)
*
* 길이 L이 주어졌을 때, 길이가 L인 올바른 괄호 문자열의 개수를 구하는 문제
*
* 첫번째 글자는 무조건 여는괄호 '('가 되어야 한다
* 왜냐하면 닫는 괄호가 처음 나와버리면 다음에 어떤 것이 오더라도 올바른 괄호 문자열이 될 수 없기 때문이다
*
*               ( +올바른 괄호 문자열
* 첫 번째 글자와 대응하는 ')'는 어디에 있을까? -> 알수 없다
*
* 만약, 전체 길이가 n이고 첫번째 여는괄호와 대응하는 닫는괄호의 위치를 i라 한다면
*
*       (  올바른 괄호 문자열  ) 올바른 괄호 문자열
*                         i
*       |_________________| |____________|
*           길이 i-2             길이 N-i
*
* D[L] = 길이가 L인 올바른 괄호 문자열
* D[L] = D[i-2] * D[L-i]
*
* 주의해야할 조건
* 1. i는 짝수
* 2. 2 <= i <= L
*
*
* ## Solution 2 (이차원 배열 사용)
* D[N][L] = 길이가 N인 괄호 문자열, 짝이 맞지 않는 여는 괄호의 개수 : L개
* 답은
* 길이가 N인 올바른 괄호 문자열 : D[N][0]
*
*             괄호 문자열 + )
*             |_______|
*            D[N-1][L+1]
* 마지막 괄호가 닫는 괄호라 한다면
* 마지막을 제외한, 그 이전까지 괄호문자열의 점화식은
* D[N-1][L+1]가 될것 이다.
* 길이는 1개가 빠져서 N-1이 된다.
* 마지막 닫는 괄호를 제외한다면 그 이전에 닫는 괄호와 대응하는 여는 괄호는 짝이 맞지 않게 될것이다.
* 그래서 L+1이 된다.
*
*
*             괄호 문자열 + (
*             |_______|
*            D[N-1][L-1]
* 마지막 괄호가 여는 괄호라 한다면
* 마지막을 제외한, 그 이전까지 괄호문자열의 점화식은
* D[N-1][L-1]가 될것 이다.
* 길이는 1개가 빠져서 N-1이 된다.
* 마지막 여는 괄호는 짝이 맞지 않는 여는 괄호의 개수 L개에 포함 했을 것이며
* 이게 빠졌으므로 L-1이 된다.
*
* L < 0 이 되면 절대로 올바른 괄호 문자열을 만들 수 없기 때문에, L >= 0에 대해서만 구한다
*
* D[N][L] = D[N-1][L-1] + D[N-1][L+1]
*
*
*
* * */

package dynamicProgramming;

import java.util.*;

//Sol 1
public class Bracket_10422 {
    static long[] d = new long[5001];
    static long mod = 1000000007L;
    static long go(int n){
        if(n == 0){
            return 1;
        }else if(d[n] >= 0){
            return d[n];
        }

        d[n] = 0;
        for(int i=2; i<=n; i+=2){
            d[n] += go(i-2) * go(n-i);
            d[n] %= mod;
        }

        return d[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(d, -1);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            if(n%2 == 0){ //짝수일때만 올바른 문자열이 가능하다.
                System.out.println(go(n));
            }else{
                System.out.println(0);
            }
        }
    }
}

//Sol 2
/*public class Bracket_10422 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[][] d = new long[5001][5001];
        long mod = 1000000007L;
        d[0][0] = 1;
        for(int i=1; i<=5000; i++){
            for(int j=0; j<=i; j++){
                d[i][j] = 0;

                if(j+1 <= i){
                    d[i][j] += d[i-1][j+1];
                }

                if(j-1 >= 0){
                    d[i][j] += d[i-1][j-1];
                }

                d[i][j] %= mod;
            }
        }

        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            System.out.println(d[n][0]);
        }
    }
}*/

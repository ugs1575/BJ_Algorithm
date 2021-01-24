/*
* D[i][a][b][p]
* = 길이가 i이고, A의 개수가 a개, B의 개수가 b개,
* S[i] < S[j]쌍이 p가 있는 문자열이 가능한가?
*   S[i] < S[j]쌍 -> a < b, a < c, b < c
*   c = i-a-b
*
* 길이와 a의 개수는 1 증가할 것이고, b의 개수는 변함이 없다
* a가 뒤에 온다고 해서 변화되는 쌍의 갯수는 없다
* --------------a : D[i+1][a+1][b][p]
* |____________|
*      길이 i
*
* 길이와 b의 개수는 1 증가할 것이고, a의 개수는 변함이 없다
* b가 뒤에 온다면 쌍의 개수는 앞의 a의 개수만큼 증가할 것이다.
* --------------b : D[i+1][a][b+1][p+a]
*
* 길이와 c의 개수는 1 증가할 것이고, a와 b의 개수는 변함이 없다
* c가 뒤에 온다면 쌍의 개수는 앞의 a와 b의 개수만큼 증가할 것이다.
* --------------c : D[i+1][a][b+1][p+a+b]
*
*
* */

package dynamicProgramming;

import java.util.*;

public class ABC_12969 {
    static boolean[][][][] d = new boolean[31][31][31][436];
    static char[] ans;
    static int n, k;
    //true -> 호출된적 있음
    //false -> 호출된적 없음
    static boolean go(int i, int a, int b, int p){
        if(i == n){
            if(p == k) return true;
            else return false;
        }
        if(d[i][a][b][p]) return false;
        d[i][a][b][p] = true;
        ans[i] = 'A';
        if(go(i+1, a+1, b, p)) return true;

        ans[i] = 'B';
        if(go(i+1, a, b+1, p+a)) return true;

        ans[i] = 'C';
        if(go(i+1, a, b, p+a+b)) return true;

        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        ans = new char[n];
        if(go(0,0,0,0)){
            System.out.println(new String(ans));
        }else{
            System.out.println(-1);
        }
    }
}

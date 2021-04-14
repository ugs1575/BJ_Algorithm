/*
* N개의 곡을 모두 추가해야 한다.
* 같은 곡 사이에는 적어도 M개의 곡이 있어야 한다.
*
* 길이가 M+1인 플레이리스트의 연속된 일부분은 모두 다른 곡으로 이루어져 있다.
* => 같은 곡이 들어있는 플레이리스트는 길이가 M+2 이상이다.
* A           A
*  |_________|
*      M개 (모두 다른곡, 만약 같은 것이 있다면 그 사이에도 M개가 있어야 하기 때문)
* A B        B A
* | |_______| |
* |____________|
*
* 같은 곡이 들어있는 플레이리스트는 길이가 M+2 이상이다.
*
* 노래를 두 개의 그룹으로 나눌 수 있다.
* 그룹 x : 이미 추가한 노래
* 그룹 y : 아직 추가하지 않은 노래
*
* 다음과 같이 점화식을 세울 수 있다.
* 길이가 p, 그룹 x=x, 그룹 y=y
* D[p][x][y] = P번째 곡을 선택할 것이고, X와 Y집합의 크기가 X,Y인 경우의 수
*
* 가장 처음, 아직 아무 노래도 추가하지 않았을 경우 X=0 Y=N
* 최종 적으로 플레이리스트를 완성했을 경우        X=N Y=0 상태가 될 것이다.
*
* 1. 그룹 Y에 있는 노래를 추가
*    = D[P+1][X+1][Y-1] * Y
* ( Y에 있는 노래는 추가 하지 않은 노래이기 때문에
*   모두 다른 노래이다.
*   Y의 모든 노래 추가하는 것은 각각 다른 경우 이기 때문에
*   Y를 곱해준다 )
*
* 2. 그룹 X에 있는 노래를 추가
*   D[P+1][X][Y] * X ..일까?? 아니다
*
*   길이 P
* ...............(우리가 추가해야할 부분)
*      |________|
*     m개(모두 다른곡)
* 추가해야할 부분에 들어가는 가짓수는 x가짓수
* M+1범위는 모두 다른 곡 이어야하기 때문에 x-m을 곱해 주어야 한다.
*    = D[P+1][X][Y] * (X-M)
*
* X+Y = N
* Y = N-X 이다. X값이 있으면 Y값을 구할 수 있다.
* Y부분을 변경해 줄 수 있다.
* 1. D[P+1][X+1][Y-1] * Y -> D[P+1][X+1] *(N-X)
* 2. D[P+1][X] * (X-M)
 *
 * */


package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class PlayList_12872 {
    static final long mod = 1000000007;
    static long[][] d = new long[101][101];
    static int n,m,p;
    static long go(int position, int x){
        int y = n-x;
        if(position == p){ //길이가 p이고
            if (y == 0) return 1; //아직 추가하지 않은 노래가 없으면
            else return 0;
        }
        long ans = d[position][x];
        if(ans != -1){
            return ans;
        }
        ans = 0;
        if(y > 0){ //아직 추가하지 않은 노래가 있으면
            ans += go(position+1, x+1) * y;
        }
        if(x > m){
            ans += go(position+1, x) * (x-m);
        }
        ans %= mod;
        d[position][x] = ans;
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        p = sc.nextInt();
        for(int i=0; i<101; i++){
            Arrays.fill(d[i], -1);
        }

        System.out.println(go(0, 0));
    }
}

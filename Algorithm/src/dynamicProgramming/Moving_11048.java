/*
* 다섯 가지 방법이 있다.저
*
******** 1. 방법 1
* D[i][j] 의 정의 : (1,1)에서 시작해 (i,j)에 도착하는 최대값
*
* (i,j)에 도착할수 있는 방법은 3가지 이다.
* (i-1 , j-1)에서 출발하거나
* (i-1 , j)에서 출발
* (i, j-1)에서 출발
*
* 정답은
* D[i-1][j]+A[i][j]
* D[i][j-1]+A[i][j]
* D[i-1][j-1]+A[i][j]
* 중 최대값이 된다
*
* for(int i=1; i<=n; i++){
*   for(int j=1; j<=m; j++){
*       d[i][j] = max3(d[i-1][j],d[i][j-1],d[i-1][j-1])+a[i][j];
*   }
* }
*
* 범위 검사를 하지 않은 이유
* i는 1부터 n까지, j는 1부터 m까지 범위를 주었다.
*
* i=1, j=1인경우 : d[i-1][j], d[i][j-1], d[i-1][j-1]은 0이기 때문
* i=1인 경우 : d[i-1][j] = 0 < d[i][j-1]이기 때문
* j=1인 경우 : d[i][j-1] = 0 < d[i-1][j]이기 때
*
*
******** 2. 방법 2
* D[i][j] 의 정의 : (1,1)에서 시작해 (i,j)에 도착하는 최대값
* 방법1과 점화식 정의는 같지만
* 이 값을 이용해서 어디를 갈수 있는 가를 보는 방법이다.
*
* (i, j)에서 갈 수 있는 곳은 3곳이다.
* (i+1, j), (i, j+1), (i+1, j+1)
*
* (i, j+1)로 간다고 하면
* D[i][j+1] = D[i][j]+A[i][j+1] 인데,
* 이런식으로만 한다면
* D[i][j+1]도 세가지 방향에서 도착해서 값을 바꿀 수 있다.
* 그러므로 기존 값과 비교해서 최대값을 넣어주면 된다.
* D[i][j+1] = max(D[i][j+1], D[i][j]+A[i][j+1])
*
* for(int i=1; i<=n; i++){
*   for(int j=1; j<=m; j++){
*       if(d[i][j+1] < d[i][j] + a[i][j+1]){
*           d[i][j+1] = d[i][j] + a[i][j+1];
*       }
*
*       if(d[i+1][j] < d[i][j] + a[i+1][j]){
*           d[i+1][j] = d[i][j] + d[i+1][j];
*       }
*
*       if(d[i+1][j+1] < d[i][j] + a[i+1][j+1]){
*           d[i+1][j+1] = d[i][j] + a[i+1][j+1];
*       }
*   }
* }
*
*
******** 3. 방법 3
* 첫번째 방법과 동일하나
* 대각선 이동은 처리하지 않아도 된다.
* 왜냐하면 사탕을 가장 많이 먹을 수 있는 방법이니까
* 대각선 이동은 다른 2가지 방법보다 항상 사탕을 적게 먹을 수 밖에 없다.
* 대각선 이동은 2곳을 방문하고 나머지 두가지 방법은 3곳을 방문 하기 때문이다.
*
* for(int i=1; i<=n; i++){
*   for(int j=1; j<=m; j++){
*       d[i][j] = max3(d[i-1][j],d[i][j-1])+a[i][j];
*   }
* }
*
*
******** 4. 방법 4
* 기존 Bottom-up 방식에서 재귀함수 호출방식, Top-down방식으로 변경할 수 있다.
* Top-down함수는 칸 1개를 채우기위한 함수이다.
* Bottom-up 방식과 식은 똑같지만, 채워진 값을 이용하는 Bottom-up 방식과는 달리
* 채워지지 않을 수 도 있기 때문에 이 부분을 함수 호출 하는 방식으로 바꿔주면 된다.
*
* // Top-down
* int go(int i, int j){
*   if(i < 1 || j < 1){
*       return 0; // 1보다 작으면 함수 호출을 멈춘다.
*   }
*   if(d[i][j] > 0){
*       return d[i][j]; //memoization 추가
*   }
*
*   d[i][j] = max(go(i-1, j), go(i, j-1)) + a[i][j];
*   return d[i][j];
* }
*
* 이렇게 하면 시간 초과를 받게 된다.
* 사탕의 개수가 0보다 크거나 같기 때문에
* d[i][j]에 들어있는 값이 0인 경우가 답을 구했는데, 0일 수도 있다.
* 따라서, 같은 문제의 정답을 여러 번 구하게 된다.
* 답이 음수인 경우는 절대로 없기 때문에, 배열을 -1로 초기화 하고 사용한다.
*
* 초기 go(n, m)호출
*
*
******** 5. 방법 5
*
* 지금까지의 점화식
* D[i][j] = (i,j)로 이동했을 때, 가져올 수 있는 최대 사탕 개수
* 시작은(1,1)로 정해져 있고, 도착(i,j)을 이동시키는 방식
*
*
* 점화식을 조금 바꿔서 세워보자.
* D[i][j] = (i,j)에서 이동을 시작했을 때, 가져올 수 있는 최대 사탕 개수
* 도착은(n,m)로 정해져 있고, 시작(i,j)을 이동시키는 방식
*
* 정답은 D[1][1]에 있다.
* 즉, go(1,1)을 호출해서 답을 구해야 한다.
*
* (x,y) -> (x+1,y)
*       -> (x,y+1)
*       재귀함수 호출 부분
*
* int go(int x, int y){
*   if(x > n || y > m) return 0;
*   if(d[x][y] >= 0) return d[x][y];
*   d[x][y] = max(go(x+1,y), go(x,y+1)) + a[x][y];
*   return d[x][y];
* }
*
*
* * */



package dynamicProgramming;

import java.util.Scanner;

public class Moving_11048 {
    static int n;
    static int m;
    static int[][] a;
    static int[][] d;
    static int go2(int x, int y){
        if(x > n || y > m){
            return 0;
        }
        if(d[x][y] >= 0){
            return d[x][y];
        }

        d[x][y] = Math.max(go2(x+1,y), go2(x, y+1))+a[x][y];
        return d[x][y];
    }
    /*static int go(int x, int y){
        if(x < 1 || y < 1){
            return 0;
        }

        if(d[x][y] >= 0){
            return d[x][y];
        }

        d[x][y] = Math.max(go(x, y-1), go(x-1,y)) + a[x][y];
        return d[x][y];
    }*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        /*int[][] a = new int[n+1][m+1];
        int[][] d = new int[n+1][m+1];*/
        a = new int[n+1][m+1];
        d = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                a[i][j] = sc.nextInt();
                //방법 4,5
                d[i][j] = -1;
            }
        }

        //방법 4
        //System.out.println(go(n, m));

        //방법 5
        System.out.println(go2(1, 1));

        //방법 1
        /*for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                d[i][j] = Math.max(d[i-1][j], Math.max(d[i-1][j-1], d[i][j-1]));
                d[i][j] += a[i][j];
            }
        }

        System.out.println(d[n][m]);*/

        //방법 2
        /*d[1][1] = a[1][1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(j+1 <= m && d[i][j+1] < d[i][j] + a[i][j+1]){
                    d[i][j+1] = d[i][j] + a[i][j+1];
                }
                if(i+1 <= n && d[i+1][j] < d[i][j] + a[i+1][j]){
                    d[i+1][j] = d[i][j] + a[i+1][j];
                }
                if(i+1 <= n && j+1 <= m && d[i+1][j+1] < d[i][j] + a[i+1][j+1]){
                    d[i+1][j+1] = d[i][j] + a[i+1][j+1];
                }
            }

        }*/

        //방법3
        /*for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
                d[i][j] += a[i][j];
            }
        }*/
    }
}

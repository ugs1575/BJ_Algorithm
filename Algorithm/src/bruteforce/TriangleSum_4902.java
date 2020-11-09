/*
*                  1,1
*              2,1 2,2 2,3
*          3,1 3,2 3,3 3,4 3,5
*     4,1 4,2 4,3 4,4 4,5 4,6 4,7
* 5,1 5,2 5,3, 5,4 5,5 5,6 5,7 5,8 5,9
*
* 삼각형에 좌표를 붙여준뒤
* 값이 변하지 않는 다는 점을 이용해서
* 매번 더하지 말고
* 미리 행마다 값을 다 저장해서 불러오는 방식으로 계산하자
*
* 예를 들어 2,3에서 n=3 인 삼각형의 합을 계산한다면
* 2,1~2,2 더한값에서 2,1~2,2 더한값
* + 3,1~3,5 더한값에서 3,1~3,2 더한값 빼기.. 이런식으로 더해주면 된다.
*
* calc함수
* row : 행
* left : 왼쪽 모서리 삼각형 열번호
* right : 오른쪽 모서리 삼각형 열번호
*
* 열번호가 홀수이면 삼각형 모양이고,
* row는 +1, left은 그대로 right+2
*
* 짝수이면 역삼각형 모양이다
* row는 -1, left-2, right는 그대로 호출해준
*
* 이점을 이용해서
* 각 삼각형마다 삼각형 크기를 계속 늘려주는 방법으로 구한다
*
* */


package bruteforce;

import java.util.*;

public class TriangleSum_4902 {
    static int n;
    static int[][] a = new int[401][801];
    static int[][] s = new int[401][801];
    static int ans;
    static void calc(int row, int left, int right, int sum){
        if(row < 1 || row > n) return;
        if(left < 1 || right > 2*row-1) return;
        sum += s[row][right] - s[row][left-1];
        if(sum > ans) ans = sum;
        if(left % 2 == 0){
            calc(row-1, left-2, right, sum);
        }else{
            calc(row+1, left, right+2, sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc=1;; tc++){
            n = sc.nextInt();
            if(n == 0) break;
            ans = -100000;
            for(int i=1; i<=n; i++){
                for(int j=1; j<=2*i-1; j++){
                    a[i][j] = sc.nextInt();
                    s[i][j] = s[i][j-1] + a[i][j];
                }
            }
            for(int i=1; i<=n; i++){
                for(int j=1; j<=2*i-1; j++){
                    calc(i, j, j, 0);
                }
            }
            System.out.printf("%d. %d\n", tc, ans);
        }
    }
}

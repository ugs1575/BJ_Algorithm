/*
*  0 -> 1 , 1 -> 0 이렇게 바꿀 수 있다.
*  즉, 3*3연산을 한번도 사용하지 않거나 한번 사용할 수 있다.
*  왜냐하면 한번 이상 사용하면 원상태로 돌아 오기 때문에 사용하지 않은 것과 같기 때문이다.
*  예를 들어 5x5행렬에서 각 칸마다 가능한 연산 횟수를 적어주면
*  1 2 3 2 1
*  2 3 4 3 2
*  3 4 5 4 3
*  2 3 4 3 2
*  1 2 3 2 1
*
*  (0,0)을 바꿀 수 있는 연산은 한가지뿐이다.
*  (0,0)을 결정해주면 (0,1)에서 가능한 연산도 한가지가 남는다
*  연속해서 실행해주면 (0,0) ~ (n-3,m-3)에서 가능한 연산이 1가지가 남는다
*
*  (0,0)에서 부터 3*3연산을 실행하면, 연산의 첫번째 칸 (0,0)을 기준으로 A행렬과 B행렬 원소값을 비교했을 때
*  다르면 무조건 연산을 실행해야한다. (한번밖에 실행할 수 없기 때문에)
*  다음 (0,1)을 기준으로 3*3연산을 실행할지 안할지 결정한다
*  위와 같은 방법으로 마지막 연산이되는 (n-3, m-3) 이 첫번째칸이 되는 마지막 연산까지 실행한다.
*  결과적으로 (0,0) ~ (n-3,m-3)은 B행렬 원소들과 같은 값이 된다.
*  여기까지 했으면 연산은 끝남 (최대 한번 연산을 실행할 수 있으니)
*  A,B 행렬을 비교해서 하나라도 다른 값이 있으면 B행렬로 바꿀수 없으므로 -1 출력 아니면 연산 횟수 출력
*
* */

package greedy;

import java.util.Scanner;

public class Matrix_1080 {
    /*
    * 3*3이면 가운데 칸(x,y)를 기준으로 바꿔준다
    *    y-1 y y+1
    * x-1
    * x
    * x+1
    * */
    static void flip(int[][] a, int x, int y){
        for(int i=x-1; i<=x+1; i++){
            for(int j=y-1; j<=y+1; j++){
                a[i][j] = 1-a[i][j];
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];

        //A행렬 입력받기
        for(int i=0; i<n; i++){
            String str = sc.next();
            for(int j=0; j<m; j++){
                a[i][j] = str.charAt(j)-'0';
            }
        }

        //B행렬 입력받기
        for(int i=0; i<n; i++){
            String str = sc.next();
            for(int j=0; j<m; j++){
                b[i][j] = str.charAt(j)-'0';
            }
        }

        int ans = 0;
        //n-3 m-3까지 검사해서 다르면 바꾸기
        for(int i=0; i<=n-3; i++){
            for(int j=0; j<=m-3; j++){
                if(a[i][j] != b[i][j]){
                    ans += 1;
                    flip(a, i+1, j+1);
                }
            }
        }

        //A=B인지 검사
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i][j] != b[i][j]){
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(ans);
    }
}

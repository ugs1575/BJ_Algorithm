/*
* 이 문제는 이 문제는 특별한 알고리즘을 이용해서 푸는 문제는 아니다.
* 그러나 주어진 조건과 문제 내용을 토대로 모든 경우의 수를 구하는 게 아닌 최적의 방법을 생각해서 풀어야 한다.
*
* a1 a2 a3
* a4 a5 a6
* a7 a8 a9
*
* 이러한 A배열이 있을 때 B배열의 값은
* (a1+a3+a7+a9) + 2*(a2+a4+a6+a8) +4*a5 이 된다.
* 여기에서 4부분으로 나누어서 계산 할 수 있다.

i) 배열의 각 모서리는 한 번씩만 더해진다.
ii) 모서리를 제외한 0번 행과 열, N-1번 행, M-1번 열의 값들은 두 번씩 더해진다.
iii) 중간 행의 (0번, M-1번), 중간 열의 (0번, N-1번) 값들은 두 번씩 더해진다.
iiii) 중간 행,열의 나머지 값들은 네 번씩 더해진다.

* 위의 사항들로 생각해보면 중간의 행, 열끼리 위치를 교환해도 B 배열의 값은 변하지 않는다는 것을 유추할 수 있다.
*
* 그리고 조건에서 최대 1번 교환할 수 있기 때문에
* 0번 행과 열, N-1번 행, M-1번 열 중 하나와
* 중간의 행,열 중 하나를 교환하면 된다.
*
* 이 중 최대값을 구해야 하기 때문에
* 0번 행과 열, N-1번 행, M-1번 열 중 합이 가장 큰 하나와
* 중간의 행, 열 중 합이 가장 작은 행, 열 하나와 바꿔서 비교해보면 최대값을 구할 수 있다.
*
* 이때 초기 배열의 값과도 비교해봐야 한다.
*
*
*
* */

package bruteforce.etc;

import java.util.Scanner;

public class ValueOfArrayB_16971 {
    static int n, m;
    static int[][] a;
    static int change(int min_index, int index, boolean type){
        //복사
        int[][] ca = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ca[i][j] = a[i][j];
            }
        }

        if(type){ //행
            //교환
            for(int i = 0; i < m; i++) {
                int temp = ca[index][i];
                ca[index][i] = ca[min_index][i];
                ca[min_index][i] = temp;
            }
        }else{//열
            //교환
            for(int i = 0; i < n; i++) {
                int temp = ca[i][index];
                ca[i][index] = ca[i][min_index];
                ca[i][min_index] = temp;
            }
        }

        return getValue(ca);
    }
    static int getValue(int[][] a){
        int sum = 0;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<m-1; j++){
                sum += a[i][j] + a[i][j+1] + a[i+1][j] + a[i+1][j+1];
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int max = getValue(a);

        if(n > 2){
            //행
            int min_row_index = -1;
            int min_row = Integer.MAX_VALUE;
            for (int i = 1; i < n-1; i++) { //중간행들 중 가장 합이 작은 행 찾기
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += a[i][j];
                }

                sum = 4*sum - 2*(a[i][0]+a[i][m-1]); //가장자리는 두번 더 더해줬으므로 빼준다.

                if (min_row > sum) {
                    min_row = sum;
                    min_row_index = i;
                }

            }

            int res1 = change(min_row_index, 0, true);
            int res2 = change(min_row_index, n-1, true);

            max = Math.max(max, Math.max(res1, res2));

        }

        if(m > 2){
            //열
            int min_col_index = -1;
            int min_col = Integer.MAX_VALUE;
            for (int j = 1; j < m-1; j++) {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += a[i][j];
                }

                sum = 4*sum - 2*(a[0][j]+a[n-1][j]);

                if (min_col > sum) {
                    min_col = sum;
                    min_col_index = j;
                }

            }

            int res1 = change(min_col_index, 0, false);
            int res2 = change(min_col_index, m-1, false);

            max = Math.max(max, Math.max(res1, res2));
        }

        System.out.println(max);


    }
}

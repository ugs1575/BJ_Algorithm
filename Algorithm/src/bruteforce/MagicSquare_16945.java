package bruteforce;

import java.util.Scanner;

public class MagicSquare_16945 {
    static int n = 3;
    static int[][] square = new int[n][n];
    static int[][] cost = new int[10][10];
    static boolean isMagicSquare(int[][] square2){

        int res = -1;

        //행 검사
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=0; j<n; j++){
                sum += square2[i][j];
            }
            if(res == -1) res = sum;
            if(res != sum) return false;
        }

        //행 검사
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=0; j<n; j++){
                sum += square2[j][i];
            }
            if(res != sum) return false;
        }

        //대각선 검사
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0; i<n; i++){
            sum1 += square2[i][i];
            sum2 += square2[i][2-i];
        }
        if(res != sum1 || res != sum2) return false;

        return true;

    }
    static int getCost(int[][] square2){
        int c = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(square[i][j] != square2[i][j]){
                    c += cost[square[i][j]][square2[i][j]];
                }
            }
        }

        return c;
    }
    static int permutatation(int[] a, boolean[] check, int index){
        int min = 0;
        if(index == 9){
            int[][] square2 = new int[n][n];
            int k = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    square2[i][j] = a[k++];
                }
            }
            boolean res = isMagicSquare(square2);
            if(res){
                int c = getCost(square2);
                return c;
            }else{
                return -1;
            }
        }
        for(int i=1; i<=9; i++){
            if(check[i]) continue;
            a[index] = i;
            check[i] = true;
            int c = permutatation(a, check, index+1);
            if(c > 0){
                if(min == 0){
                    min = c;
                }else{
                    if(min > c){
                        min = c;
                    }
                }

            }
            check[i] = false;
        }

        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                square[i][j] = sc.nextInt();
            }
        }

        for(int i=1; i<=9; i++){
            for(int j=1; j<=9; j++){
                if(i==j) continue;
                cost[i][j] = Math.abs(i-j);
            }
        }

        int min = 0;
        if(!isMagicSquare(square)) {
            int[] a = new int[9];
            boolean[] visit = new boolean[10];
            int res = permutatation(a, visit, 0);
            if (res > 0) {
                if (min == 0) {
                    min = res;
                } else {
                    if (min > res) min = res;
                }
            }
        }


        System.out.println(min);
    }
}

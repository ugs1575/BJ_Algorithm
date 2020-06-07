package bruteforce;

import java.util.Scanner;

public class Tetromino_14500 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] paper = new int[n][m];

        int[] x = {0,0,1,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,2,3,0,1,1,2,0,1,2,2,0,1,2,2,0,1,1,1,0,1,1,1,0,0,1,2,0,0,1,2,0,1,1,2,0,0,-1,-1,0,0,1,1,0,-1,0,0,0,-1,0,1,0,1,2,1};
        int[] y = {0,1,0,1,0,1,2,2,0,1,2,1,0,1,2,0,0,1,2,3,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,-1,0,0,1,2,0,0,-1,-2,0,1,0,0,0,1,1,1,0,0,-1,-1,0,1,1,2,0,1,1,2,0,1,1,2,0,1,1,1,0,0,0,1};


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                paper[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<76; k+=4){
                    int sum = 0;

                    for(int t=k; t<k+4; t++){
                        if(i+x[t] >= 0 && i+x[t] < n && j+y[t] >= 0 && j+y[t] < m) {
                            sum += paper[i + x[t]][j + y[t]];
                        }else{
                            sum = 0;
                            break;
                        }
                    }

                    if (sum > ans){
                        ans = sum;
                    }
                }
            }
        }

        System.out.print(ans);
    }
}

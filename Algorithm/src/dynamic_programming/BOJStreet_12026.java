package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class BOJStreet_12026 {
    static int[][] d;
    static int go(int i, int j, String s){
        if(d[i][j] != -1){
            return d[i][j];
        }

        char find = 'J';
        if(s.charAt(j) == 'J'){
            find = 'O';
        }else if(s.charAt(j) == 'O'){
            find = 'B';
        }

        for(int k=j-1; k>=0; k--){
            if(s.charAt(k) == find){
                int diff = j-k;
                int energy = diff*diff;
                int temp = go(i, j-diff, s);
                if(temp != -1){
                    if(d[i][j] == -1){
                        d[i][j] = temp+energy;
                    }else{
                        d[i][j] = Math.min(d[i][j], temp+energy);
                    }
                }
            }
        }

        return d[i][j];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        d = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(d[i],-1);
        }
        d[0][0] = 0;
        go(0, n-1, s);
        System.out.println(d[0][n-1]);
    }
}

package graph.shortestPath.floydWarshall;

import java.util.Scanner;

public class FindingPath_11403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j] = sc.nextInt();
            }
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(a[i][k] == 1 && a[k][j] == 1){
                        a[i][j] = 1;
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }


    }
}

package graph.shortestPath.floydWarshall;

import java.util.Scanner;

public class Exercising_1956 {
    static final int inf = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] d = new int[v+1][v+1];

        for(int i=1; i<=v; i++){
            for(int j=1; j<=v; j++){
                if(i == j) d[i][j] = 0;
                else d[i][j] = inf;
            }
        }

        for(int i=0; i<e; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            d[from][to] = cost;
        }

        for(int k=1; k<=v; k++){
            for(int i=1; i<=v; i++){
                for(int j=1; j<=v; j++){
                    if(d[i][j] > d[i][k]+d[k][j]){
                        d[i][j] = d[i][k]+d[k][j];
                    }
                }
            }
        }

        int min = inf;
        for(int i=1; i<=v; i++){
            for(int j=1; j<=v; j++){
                if(i == j) continue;
                if(d[i][j] == inf && d[j][j] == inf) continue;
                if(min > d[i][j] + d[j][i]){
                    min = d[i][j] + d[j][i];
                }
            }
        }

        if(min == inf) min = -1;

        System.out.println(min);

    }
}

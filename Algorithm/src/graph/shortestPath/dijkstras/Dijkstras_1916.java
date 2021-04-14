package graph.shortestPath.dijkstras;

import java.util.ArrayList;
import java.util.Scanner;

class Edge3 {
    int to, cost;
    Edge3(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}

public class Dijkstras_1916 {
    static final int inf = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Edge3>[] list = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            list[from].add(new Edge3(to, cost));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        int[] d = new int[n+1];
        boolean[] c = new boolean[n+1];
        for(int i=1; i<=n; i++){
            d[i] = inf;
            c[i] = false;
        }
        d[start] = 0;
        for(int i=0; i<n-1; i++){
            int min = inf;
            int min_index = -1;
            for(int j=1; j<=n; j++){
                if(!c[j] && min >= d[j]){
                    min = d[j];
                    min_index = j;
                }
            }
            c[min_index] = true;
            for(Edge3 e:list[min_index]){
                if(d[min_index] != inf && d[e.to] > d[min_index]+e.cost){
                    d[e.to] = d[min_index]+e.cost;
                }
            }
        }

        System.out.println(d[end]);

    }
}

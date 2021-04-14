package graph.shortestPath.bellmanFord;

import java.util.ArrayList;
import java.util.Scanner;

class Edge2{
    int from, to, cost;
    Edge2(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class WormHole_1865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int w = sc.nextInt();
            ArrayList<Edge2> a = new ArrayList<>();
            for(int i=0; i<m; i++){
                int from = sc.nextInt();
                int to = sc.nextInt();
                int cost = sc.nextInt();
                a.add(new Edge2(from, to, cost));
                a.add(new Edge2(to, from, cost));
            }

            for(int i=0; i<w; i++){
                int from = sc.nextInt();
                int to = sc.nextInt();
                int cost = sc.nextInt();
                a.add(new Edge2(from, to, -cost));
            }

            int[] dist = new int[n+1];
            for(int i=1; i<=n; i++){
                dist[i] = 0;
            }

            boolean negative_cycle = false;
            for(int i=1; i<=n; i++){
                for(Edge2 e : a){
                    int x = e.from;
                    int y = e.to;
                    int z = e.cost;
                    if(dist[y] > dist[x]+z){
                        dist[y] = dist[x] + z;
                        if(i == n){
                            negative_cycle = true;
                        }
                    }
                }
            }

            System.out.println(negative_cycle? "YES":"NO");
        }
    }
}

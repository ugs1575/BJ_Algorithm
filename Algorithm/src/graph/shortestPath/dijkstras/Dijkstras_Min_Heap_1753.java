package graph.shortestPath.dijkstras;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge4 implements Comparable<Edge4>{
    int to, cost;
    Edge4(int to, int cost){
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge4 that) {
        if(this.cost < that.cost){
            return -1;
        }else if(this.cost == that.cost){
            if(this.to < that.to) return -1;
            else if(this.to > that.to) return 1;
            else return 0;
        }else{
            return 1;
        }
    }
}

public class Dijkstras_Min_Heap_1753 {
    static final int inf = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Edge4>[] list = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        int start = sc.nextInt();

        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            list[u].add(new Edge4(v, w));
        }

        int[] dist = new int[n+1];
        boolean[] check = new boolean[n+1];
        for(int i=1; i<=n; i++){
            dist[i] = inf;
            check[i] = false;
        }
        dist[start] = 0;
        PriorityQueue<Edge4> q = new PriorityQueue<>();
        q.add(new Edge4(start, 0));
        while (!q.isEmpty()){
            int x = q.remove().to;
            if(check[x]) continue;
            check[x] = true;
            for(Edge4 y : list[x]){
                if(dist[x] != inf && dist[y.to] > dist[x]+y.cost){
                    dist[y.to] = dist[x]+y.cost;
                    q.add(new Edge4(y.to, dist[y.to]));
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(dist[i] == inf){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
    }
}

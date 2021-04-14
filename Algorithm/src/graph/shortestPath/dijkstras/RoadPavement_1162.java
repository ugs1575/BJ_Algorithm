package graph.shortestPath.dijkstras;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge7{
    int to;
    int cost;
    Edge7(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}

class Node implements Comparable<Node>{
    long cost;
    int vertex;
    int step;
    public Node(long cost, int vertex, int step) {
        this.cost = cost;
        this.vertex = vertex;
        this.step = step;
    }


    @Override
    public int compareTo(Node that) {
        if(this.cost < that.cost){
            return -1;
        }else if(this.cost == that.cost){
            return 0;
        }else{
            return 1;
        }
    }
}

public class RoadPavement_1162 {
    static final long inf = 1000000L*50000L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int start = 1;
        int end = n;

        ArrayList<Edge7>[] list = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            list[from].add(new Edge7(to, cost));
            list[to].add(new Edge7(from, cost));
        }

        long[][] dist = new long[n+1][k+1];
        boolean[][] check = new boolean[n+1][k+1];

        for(int i=1; i<=n; i++){
            for(int j=0; j<=k; j++){
                dist[i][j] = inf;
            }
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0,start,0));
        dist[start][0] = 0;
        while (!q.isEmpty()){
            Node x = q.remove();
            int cur = x.vertex;
            int step = x.step;
            if(check[cur][step]) continue;
            check[cur][step] = true;

            for(Edge7 e : list[cur]){
                int next = e.to;
                long cost = e.cost;
                //포장 하는 경우
                if(step+1 <= k  && dist[next][step+1] > dist[cur][step]){
                    dist[next][step+1] = dist[cur][step];
                    q.add(new Node(dist[next][step+1], next, step+1));
                }
                //포장 안하는 경우
                if(dist[next][step] > dist[cur][step] + cost){
                    dist[next][step] = dist[cur][step] + cost;
                    q.add(new Node(dist[next][step], next, step));
                }
            }
        }

        long ans = inf;
        for(int i=0; i<=k; i++){
            if(check[end][i] && dist[end][i] < ans) ans = dist[end][i];
        }

        System.out.println(ans);
    }
}

package graph.shortestPath.dijkstras;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge6 implements Comparable<Edge6>{
    int to, cost;
    Edge6(int to, int cost){
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge6 that) {
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

public class SpecificShortestPath_1504 {
    static final int inf = 100000000;
    static int n;
    static ArrayList<Edge6>[] list;
    static int[] findPath(int start){
        int[] dist = new int[n+1];
        boolean[] check = new boolean[n+1];
        for(int i=1; i<=n; i++){
            dist[i] = inf;
            check[i] = false;
        }

        dist[start] = 0;
        PriorityQueue<Edge6> q = new PriorityQueue<>();
        q.add(new Edge6(start, 0));
        while (!q.isEmpty()){
            int x = q.remove().to;
            if(check[x]) continue;
            check[x] = true;
            for(Edge6 y : list[x]){
                if(dist[x] != inf && dist[y.to] > dist[x] + y.cost){
                    dist[y.to] = dist[x]+y.cost;
                    q.add(new Edge6(y.to, dist[y.to]));
                }
            }

        }

        return dist;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            list[from].add(new Edge6(to, cost));
            list[to].add(new Edge6(from, cost));
        }

        int start = 1;
        int end = n;
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();


        int[] dist1 = findPath(start);
        int[] dist2 = findPath(v1);
        int[] dist3 = findPath(v2);
        int ans = dist1[v1] + dist2[v2] + dist3[end];
        int ans1 = dist1[v2] + dist3[v1] + dist2[end];

        if(ans > ans1){
            ans = ans1;
        }

        if(ans >= inf){
            ans = -1;
        }

        System.out.println(ans);


    }
}

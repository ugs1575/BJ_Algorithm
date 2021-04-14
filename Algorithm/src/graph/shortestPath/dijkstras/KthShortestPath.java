package graph.shortestPath.dijkstras;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge8 implements Comparable<Edge8>{
    int to;
    int cost;

    public Edge8(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge8 that) {
        if(this.cost < that.cost){
            return -1;
        }else if(this.cost == that.cost){
            return 0;
        }else{
            return 1;
        }
    }
}

public class KthShortestPath {
    static final int inf = 2000000*1000;
    static class Compare implements Comparator<Integer>{
        public int compare(Integer one, Integer two){
            return two.compareTo(one);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Edge8>[] path = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            path[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            path[from].add(new Edge8(to, cost));
        }


        PriorityQueue<Integer>[] dist = new PriorityQueue[n+1];
        Compare cmp = new Compare();
        for(int i=1; i<=n; i++){
            dist[i] = new PriorityQueue<Integer>(1, cmp);
        }
        dist[1].offer(0);
        PriorityQueue<Edge8> q = new PriorityQueue<>();
        q.add(new Edge8(1, 0));
        while (!q.isEmpty()){
            Edge8 p = q.remove();
            int x = p.to;
            int cur = p.cost;
            for(Edge8 e: path[x]){
                int y = e.to;
                if(dist[y].size() < k || dist[y].peek() > cur + e.cost){
                    if(dist[y].size() == k){
                        dist[y].poll();
                    }
                    dist[y].offer(cur+e.cost);
                    q.add(new Edge8(y, (cur+e.cost)));
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(dist[i].size() != k){
                System.out.println(-1);
            }else{
                System.out.println(dist[i].peek());
            }
        }
    }
}

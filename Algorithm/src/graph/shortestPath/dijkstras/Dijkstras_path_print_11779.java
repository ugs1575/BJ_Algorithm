package graph.shortestPath.dijkstras;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

class Edge5 implements Comparable<Edge5>{
    int to, cost;
    Edge5(int to, int cost){
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge5 that) {
        if(this.cost < that.cost){
            return -1;
        }else if(this.cost == that.cost){
            if(this.to < that.to){
                return -1;
            }else if(this.to > that.to){
                return 1;
            }else{
                return 0;
            }
        }else{
            return 1;
        }
    }
}

public class Dijkstras_path_print_11779 {
    static final int inf = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Edge5>[] a = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            a[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            a[u].add(new Edge5(v, w));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        int[] dist = new int[n+1];
        boolean[] visit = new boolean[n+1];
        int[] path = new int[n+1];
        for(int i=0; i<=n; i++){
            dist[i] = inf;
            visit[i] = false;
        }
        PriorityQueue<Edge5> q = new PriorityQueue<>();
        dist[start] = 0;
        path[start] = -1;
        q.add(new Edge5(start, 0));

        while (!q.isEmpty()){
            Edge5 ed = q.remove();
            int x = ed.to;
            if(visit[x]) continue;
            visit[x] = true;
            for(Edge5 e:a[x]){
                if(dist[x] != inf && dist[e.to] > dist[x]+e.cost){
                    dist[e.to] = dist[x]+e.cost;
                    path[e.to] = x;
                    q.add(new Edge5(e.to, dist[e.to]));
                }
            }
        }

        Stack<Integer> st = new Stack<>();
        int x = end;
        while (x != -1){
            st.push(x);
            x = path[x];
        }

        System.out.println(dist[end]);
        System.out.println(st.size());
        while (!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }


    }
}

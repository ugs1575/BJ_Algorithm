package graph.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Edge2{
    int from, to, cost;
    Edge2(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

class Edge2Comparator implements Comparator<Edge2>{

    @Override
    public int compare(Edge2 o1, Edge2 o2) {
        return o1.cost-o2.cost;
    }
}

public class Kruskal_1197 {

    public static void disjoint_union(int[] p, int x, int y){
        x = find(p, x);
        y = find(p, y);
        p[x] = y;
    }
    public static int find(int[] p, int x){
        if(x == p[x]){
            return x;
        }else{
            return (p[x] = find(p, p[x]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[n+1];
        for(int i=0; i<=n; i++){
            p[i] = i;
        }
        ArrayList<Edge2> a = new ArrayList<>();
        for(int i=0; i<m; i++){
            a.add(new Edge2(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a, new Edge2Comparator());
        int ans = 0;
        for(Edge2 e : a){
            int x = find(p, e.from);
            int y = find(p, e.to);
            if(x != y){
                disjoint_union(p, e.from, e.to);
                ans += e.cost;
            }
        }
        System.out.println(ans);
    }
}

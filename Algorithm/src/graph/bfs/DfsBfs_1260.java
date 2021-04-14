package graph.bfs;

import java.util.*;
/*
반례
6 6 1
        1 2
        2 3
        3 4
        4 2
        4 5
        2 6
틀림 원인, bfs while문 안에서 호출 안하고 있었음
        */

public class DfsBfs_1260 {

    static ArrayList<Integer>[] aList;
    static boolean[] c;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        //array of arraylist
        aList = new ArrayList[n+1];

        for(int i=0; i<n+1; i++){
            aList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            aList[u].add(v);
            aList[v].add(u);
        }
        for(int i=1; i<=n; i++){
            Collections.sort(aList[i]);
        }

        c = new boolean[n+1];
        dfs(start);
        System.out.println();
        c = new boolean[n+1];
        bfs(start);


    }

    public static void dfs(int vertex){
        if(c[vertex]){
            return;
        }
        c[vertex] = true;
        System.out.print(vertex+" ");
        for(int i=0; i < aList[vertex].size(); i++){
            int next = aList[vertex].get(i);
            if(c[next] == false){
                dfs(next);
            }
        }
    }

    public static void bfs(int vertex){
        Queue<Integer> q = new LinkedList<Integer>();
        c[vertex] = true;
        q.add(vertex);

        while (!q.isEmpty()){
            vertex = q.peek();
            for(int i=0; i < aList[vertex].size(); i++){
                int next = aList[vertex].get(i);
                if(!c[next]) {
                    c[next] = true;
                    q.add(next);
                }
            }
            vertex = q.remove();
            System.out.print(vertex+" ");

        }



    }

}

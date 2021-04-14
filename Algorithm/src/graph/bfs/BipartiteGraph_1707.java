package graph.bfs;/*
시작하는 정점을 정해주는것이 아님
항상 1에서 시작하는 것이 아니라 어느정점에서 시작하던 같은 답이 나와야함
*/

import java.util.*;

public class BipartiteGraph_1707 {
    static ArrayList<Integer>[] aList;
    static int[] check;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int t=0; t<testCase; t++){
           int v = sc.nextInt(); //정점갯수
           int e = sc.nextInt(); //간선갯수
           aList = new ArrayList[v+1];
           for(int i=0; i<v+1; i++){
               aList[i] = new ArrayList<Integer>();
           }
           check = new int[v+1];
           for(int i=0; i<e; i++){
               int start = sc.nextInt();
               int end = sc.nextInt();
               aList[start].add(end);
               aList[end].add(start);
           }

           for(int i=1; i<=v; i++){
               Collections.sort(aList[i]);
           }

            for (int i=1; i<=v; i++) {
                if (check[i] == 0) {
                    dfs(i, 1);
                }
            }


           boolean biGraph = isBipartite(check, aList, v);
           if(biGraph){
               System.out.println("YES");
           }else{
               System.out.println("NO");
           }
        }
    }



    public static void dfs(int vertex, int color){
        check[vertex] = color;

        for(int i=0; i<aList[vertex].size(); i++){
            int next = aList[vertex].get(i);
            if(check[next] == 0){
                dfs(next, 3-color);
            }
        }

    }

    public static boolean isBipartite(int[] check, ArrayList<Integer>[] aList, int v){
        for(int i=1; i<=v; i++){
            int checkVal = check[i];
            for(int j=0; j<aList[i].size(); j++){
                int vertex = aList[i].get(j);
                if(check[vertex] == checkVal)
                    return false;
            }
        }
        return true;
    }
}

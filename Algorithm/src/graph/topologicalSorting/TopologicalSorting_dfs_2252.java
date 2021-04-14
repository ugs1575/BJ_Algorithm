package graph.topologicalSorting;

import java.util.ArrayList;
import java.util.Scanner;

public class TopologicalSorting_dfs_2252 {
    static boolean[] visit;
    static ArrayList<Integer>[] compareList;
    static void go(int x){
        visit[x] = true;

        for(int i=0; i<compareList[x].size(); i++){
            int next = compareList[x].get(i);
            if(!visit[next]) go(next);
        }

        System.out.print(x+" ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        //그래프 만들기
        compareList = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            compareList[i] = new ArrayList<>();
        }

        //그래프 저장 및 방문여부 체크
        visit = new boolean[n+1];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            compareList[b].add(a); //반대로 넣어주기 뒤집어야 하니까..
        }

        //위상정렬
        for(int i=1; i<=n; i++){
            if(!visit[i]) go(i);
        }

    }
}

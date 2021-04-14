package graph.topologicalSorting;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class WorkBook_1766 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        //그래프 만들기
        ArrayList<Integer>[] compareList = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            compareList[i] = new ArrayList<>();
        }

        //그래프 저장 및 in-degree 세기
        int[] ind = new int[n+1];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            compareList[a].add(b);
            ind[b] += 1;
        }

        //위상정렬
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=1; i<=n; i++){
            if(ind[i] == 0){
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()){
            int cur = q.remove();
            sb.append(cur+" ");
            for(int i=0; i<compareList[cur].size(); i++){
                int next = compareList[cur].get(i);
                ind[next] -= 1;
                if(ind[next] == 0){
                    q.add(next);
                }
            }
        }

        System.out.println(sb.toString());

    }
}

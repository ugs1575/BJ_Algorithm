package graph.topologicalSorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Works_2056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] time = new int[n+1];
        int[] ind = new int[n+1];
        int[] d = new int[n+1];
        ArrayList<Integer>[] workList = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            workList[i] = new ArrayList<>();
        }

        for(int i=1; i<=n; i++){
            int t = sc.nextInt();
            int cnt = sc.nextInt();
            time[i] = t;
            for(int j=0; j<cnt; j++){
                int w = sc.nextInt();
                workList[w].add(i);
                ind[i] += 1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(ind[i] == 0){
                q.add(i);
                d[i] = time[i];
            }
        }

        while (!q.isEmpty()){
            int cur = q.remove();
            for(int i=0; i<workList[cur].size(); i++){
                int next = workList[cur].get(i);
                ind[next] -= 1;
                if(time[next]+d[cur] > d[next]){
                    d[next] = time[next]+d[cur];
                }
                if(ind[next] == 0){
                    q.add(next);
                }
            }
        }

        int ans = 0;
        for (int i=1; i<=n; i++) {
            ans = Math.max(ans,d[i]);
        }
        System.out.println(ans);
    }
}

package graph.bfs;

import java.util.ArrayList;
import java.util.Scanner;

public class PermutationCycle_10451 {
    static ArrayList<Integer>[] aList;
    static int[] check;
    static int cnt=0;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int node = sc.nextInt();
            check = new int[node+1];
            aList = new ArrayList[node+1];
            for(int j=1; j<=node; j++){
                aList[j] = new ArrayList<Integer>();
                int num = sc.nextInt();
                aList[j].add(num);
            }

            dfs(1, node);
            System.out.println(cnt);
            cnt = 0;
        }

    }

    public static void dfs(int v, int size){
        if(check[v] == 0){
            check[v] = 1;
            int next = aList[v].get(0);
            dfs(next, size);
        }else{
            cnt ++;
            for(int i=1; i<=size; i++){
                if(check[i] == 0){
                    dfs(i, size);
                }
            }
        }
    }

}

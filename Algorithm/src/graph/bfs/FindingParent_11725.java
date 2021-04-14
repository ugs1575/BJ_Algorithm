package graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindingParent_11725 {
    static ArrayList<Integer>[] aList;
    static int[] check;
    static int[] depth;
    static int[] parent;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n);
        aList = new ArrayList[n+1];
        check = new int[n+1];
        depth = new int[n+1];
        parent = new int[n+1];



        for(int i=1; i<=n; i++){
            aList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<n; i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            aList[node1].add(node2);
            aList[node2].add(node1);
        }

        for(int i=0; i<aList[1].size(); i++){
            System.out.println(aList[1].get(i));
        }

        //bfs(1);

        /*for(int p:parent){
            System.out.println(parent[p]);
        }*/
    }

    public static void bfs(int root){
        System.out.println("dd");
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(root);
        check[root] = 1;
        System.out.println(q);

        while(!q.isEmpty()){
            int now = q.remove();
            for(int i=0; i<aList[now].size(); i++){
                int next = aList[now].get(i);
                if(check[next] == 0){
                    q.add(next);
                    check[next] = 1;
                    depth[next] = depth[now]+1;
                    parent[next] = now;
                }
            }
        }

    }
}

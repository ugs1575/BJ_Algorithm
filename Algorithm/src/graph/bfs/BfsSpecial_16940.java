package graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsSpecial_16940 {
    static ArrayList<Integer>[] aList;
    static int[] check;
    static int[] visitOrder;
    static int result = 1;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int nodeCnt = sc.nextInt();
        aList = new ArrayList[nodeCnt+1];
        check = new int[nodeCnt+1];
        visitOrder = new int[nodeCnt];

        for(int i=1; i<=nodeCnt; i++){
            aList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<nodeCnt-1; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            aList[from].add(to);
            aList[to].add(from);
        }


        for(int i=0; i<nodeCnt; i++){
            int n = sc.nextInt();
            if(i == 0 && n != 1){
                result = 0;
                break;
            }

            visitOrder[i] = n;
        }

        if(result != 0){
            bfs(1);
        }


        System.out.println(result);
    }

    public static void bfs(int n){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        check[n] = 1;
        int j = 1;

        while (!q.isEmpty()){
            int parent = q.remove();
            int size = 0;
            for(int i=0; i<aList[parent].size(); i++){
                int next = aList[parent].get(i);
                if(check[next] == 0){
                    size++;
                    q.add(next);
                    check[next] = parent;
                }
            }
            //System.out.println(j);
            for(int i=j; i<j+size; i++){
                if(check[visitOrder[i]] != parent || check[visitOrder[i]] == 0){
                    //System.out.println(check[visitOrder[i]]+"/"+parent);
                    result = 0;
                }
            }

            j = j+size;

        }
    }

}

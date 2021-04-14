package graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Diameter_1127 {
   static ArrayList<Integer>[] aList;
   static int[][] distance;
   
   public static void main(String args[]) {
      /*Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int max = 0;
      distance = new int[n+1][n+1];
      aList = new ArrayList[n+1];
      for(int i=1; i<=n; i++) {
         aList[i] = new ArrayList<Integer>();
      }
      
      for(int i=0; i<n; i++) {
         int from = sc.nextInt();
         while(true) {
            int to     = sc.nextInt();
            if(to == -1) {
               break;
            }else {
               int dist = sc.nextInt();
               aList[to].add(from);
               distance[to][from] = dist;
            }
         }
      }
      
      for(int i=1; i<=n; i++) {
         bfs(i, n);
      }
      */
   }
   
   public static void bfs(int root, int n) {
      /*Queue<Integer> q = new LinkedList<Integer>();
      int[] d = new int[n+1];
      int[] c = new int[n+1];
      
      q.add(root);
      c[root]= 1;
      while(!q.isEmpty()) {
         int now = q.remove();
         d[now] = d[root] + distance[now][root];
         
         for(int i=0; i<aList[now].size(); i++) {
            int next = int[][] distance
            if(c[])
         }
      }*/
      
   }

}
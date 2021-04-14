package graph.bfs;

import java.util.*;

public class BfsSpecial2_16940 {
    static ArrayList<Integer>[] aList;
    static boolean[] visit;
    static int[] order;
    static ArrayList<Integer> check;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        aList = new ArrayList[n+1];
        visit = new boolean[n+1];
        order = new int[n+1];
        check = new ArrayList<Integer>();
        int[] compare = new int[n];

        for(int i=1; i<=n; i++){
            aList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<n-1; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            aList[from].add(to);
            aList[to].add(from);
        }

        for(int i=1; i<=n; i++){
            int num = sc.nextInt();
            order[num] = i;
            compare[i-1] = num;
        }

        for(int i=1; i<=n; i++){
            Collections.sort(aList[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(order[o1] < order[o2]){
                        return -1;
                    }else if(order[o1] == order[o2]){
                        return 0;
                    }else{
                        return 1;
                    }
                }
            });
        }

        bfs(1);

        for(int i=0; i<n; i++){
            if(check.get(i) != compare[i]){
                System.out.println(0);
                System.exit(0);
            }
        }

        System.out.println(1);

    }

    public static void bfs(int node){
        Queue<Integer> q = new LinkedList<Integer>();
        visit[node] = true;
        q.add(node);
        check.add(node);

        while (!q.isEmpty()){
            int parent = q.remove();
            for(int i=0; i<aList[parent].size(); i++){
                int next = aList[parent].get(i);
                if(!visit[next]){
                    visit[next] = true;
                    q.add(next);
                    check.add(next);
                }
            }
        }

    }
}
package graph.bfs;/*5 5
1 2
2 4
2 3
3 4
4 5

        정답: 1
        출력: 0*/
import java.util.*;

public class ABCDE_12023 {
    static ArrayList<Integer>[] aList;
    static boolean[] visit;
    static boolean ans;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        aList = new ArrayList[n];

        for(int i=0; i<n; i++){
            aList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            aList[from].add(to);
            aList[to].add(from);
        }

        for(int i=0; i<n; i++){
            visit = new boolean[n];
            dfs(i, 1);
            if(ans){
                System.out.print(1);
                System.exit(0);
            }
        }

        System.out.print(0);

    }

    public static void dfs(int node, int cnt){
        if(cnt == 5){
            ans = true;
            return;
        }
        visit[node] = true;

        for(int i=0; i<aList[node].size(); i++){
            int next = aList[node].get(i);
            if(!visit[next]){
                dfs(next, cnt+1);
            }
            if(ans){
                return;
            }
        }
        visit[node] = false; //들어가야하는 이유 반례 상단
    }
}

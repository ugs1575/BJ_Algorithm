import java.util.*;

public class ConnectedComponent_11724 {
    static boolean[] check;
    static ArrayList<Integer>[] aList;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        aList = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            aList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            aList[u].add(v);
            aList[v].add(u);
        }

        check = new boolean[n+1];
        /* int cnt = 1;
        int start = 1;
        boolean stop = false;
       while (!stop){
            dfs(start);
            for(int i=1; i<n+1; i++){
                stop = check[i];
                if(check[i] == false){
                    start = i;
                    cnt++;
                    break;
                }
            }
        }*/
        int cnt = 0;
        for(int i=1; i<n+1; i++){
            if(check[i] == false){
                dfs(i);
                cnt++;
            }
        }

        System.out.print(cnt);

    }

    public static void dfs(int start){
        if(!check[start]){
            check[start] = true;
            for(int i=0; i<aList[start].size(); i++){
                int next = aList[start].get(i);
                if(!check[next]){
                    dfs(next);
                }
            }
        }


    }
}

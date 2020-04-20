import java.util.*;

public class subwayLine2_16947 {
    static ArrayList<Integer>[] aList;
    static boolean[] check;
    static int[] checkBfs;
    static boolean[] aCycle;
    static boolean findCycle;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ans = new int[n+1];
        aList= new ArrayList[n+1];
        aCycle= new boolean[n+1];
        for(int i=1; i<=n; i++){
            aList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<n; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            aList[from].add(to);
            aList[to].add(from);
        }

        for(int i=1; i<=n; i++) {
            check = new boolean[n + 1];
            findCycle = false;
            dfs(i, 1, i);
            if(findCycle){
                aCycle[i] = true;
            }

            //System.out.println("-------------------");
        }

        for(int i=1; i<=n; i++) {
            if(!aCycle[i]){
                checkBfs = new int[n + 1];
                int d = bfs(i);
                ans[i] = d;
            }
        }


        for(int i=1; i<=n; i++){
            System.out.print(ans[i]+" ");
        }


    }

    public static void dfs(int station, int cnt, int start){
        //System.out.println(station+"/"+cnt+"/"+start);
        if(check[station] && station == start && cnt>=3){
            findCycle = true;
            return;
        }

        check[station] = true;
        for(int i=0; i<aList[station].size(); i++){
            int nextStation = aList[station].get(i);
            if(check[nextStation] && nextStation == start && cnt>=3){
                dfs(nextStation, cnt, start);
            }else if(!check[nextStation]){
                dfs(nextStation, cnt+1, start);
            }
            //System.out.println("..."+station+"/"+cnt+"/"+start);
            if(findCycle){
                return;
            }
        }
    }

    public static int bfs(int station){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(station);
        checkBfs[station] = 1;
        int cnt = 0;

        while (!q.isEmpty()){
            int now = q.remove();
            cnt ++;

            if(aCycle[now]){
                //System.out.println(now+"/"+checkBfs[now]);
                return checkBfs[now]-1;
            }

            for(int i=0; i<aList[now].size(); i++){
                int next = aList[now].get(i);

                if(checkBfs[next] == 0){
                    //System.out.print(next+" ");
                    q.add(next);
                    checkBfs[next] = checkBfs[now]+1;
                }
            }
        }

        return 0;
    }
}

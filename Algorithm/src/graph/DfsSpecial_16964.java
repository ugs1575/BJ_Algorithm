import java.util.*;
public class DfsSpecial_16964 {
    static ArrayList<Integer> check;
    static boolean[] visit;
    static ArrayList<Integer>[] aList;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        check = new ArrayList<Integer>();
        visit = new boolean[n+1];
        aList = new ArrayList[n+1];
        int[] order = new int[n+1];
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

        dfs(1);



        for(int i=0; i<n; i++){
            if(compare[i] != check.get(i)){
                System.out.println(0);
                System.exit(0);
            }

        }

        System.out.println(1);




    }
    public static void dfs(int node){
        if(visit[node]){
            return;
        }

        visit[node] = true;
        check.add(node);
        for(int i=0; i<aList[node].size(); i++){
            int next = aList[node].get(i);
            if(!visit[next]){
                dfs(next);
            }
        }
    }

}

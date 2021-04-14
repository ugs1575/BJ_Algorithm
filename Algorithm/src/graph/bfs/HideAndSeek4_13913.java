package graph.bfs;

import java.util.*;

public class HideAndSeek4_13913 {
    static int[] check = new int[100001];
    static int[] aParent = new int[100001];
    static int destination;


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        destination = sc.nextInt();

        if(start != destination){
            bfs(start);
            int time = check[destination]-1;
            System.out.println(time);

            int[] ans = new int[check[destination]];
            ans[time] = destination;
            int location = destination;

            while (location != start){
                ans[--time] = aParent[location];
                location = aParent[location];
            }

            for(int i=0; i<check[destination]; i++){
                System.out.print(ans[i]+" ");
            }

        }else{
            System.out.println(0);
            System.out.print(start);
        }
    }

    public static void bfs(int node){
        boolean stop = false;
        Queue<Integer> q = new LinkedList<Integer>();
        check[node] = 1;
        q.add(node);

        while(!stop){
            int parent = q.remove();
            int[] move = {-1, 1, parent};
            for(int i=0; i<3; i++){
                int next = parent + move[i];
                if(next >= 0 && next <= 100000 && check[next] == 0){
                    q.add(next);
                    aParent[next] = parent;
                    check[next] = check[parent]+1;
                    if(next == destination){
                        stop = true;
                    }
                }
            }
        }
    }
}

import java.util.*;

public class HideAndSeek3_13549 {
    static int[] check = new int[100001];
    static int destination;


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        destination = sc.nextInt();

        if(start != destination){
            bfs(start);
            System.out.println(check[destination]-1);
        }else{
            System.out.println(0);
        }
    }

    public static void bfs(int node){
        boolean stop = false;
        Queue<Integer> q = new LinkedList<Integer>();
        check[node] = 1;
        q.add(node);

        while(!stop){
            int parent = q.remove();
            int[] move = {parent, -1, 1};
            for(int i=0; i<3; i++){
                int next = parent + move[i];
                if(next >= 0 && next <= 100000 && check[next] == 0){
                    q.add(next);
                    if(i != 0){
                        check[next] = check[parent]+1;
                    }else{
                        check[next] = check[parent];
                    }

                    if(next == destination){
                        stop = true;
                    }
                }
            }
        }
    }
}

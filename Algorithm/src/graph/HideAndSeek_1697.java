import java.util.*;

public class HideAndSeek_1697 {
    static int[] check = new int[1000001];
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
            int[] move = {-1, 1, parent};
            for(int i=0; i<3; i++){
                int next = parent + move[i];
                if(next >= 0 && next <= 1000000 && check[next] == 0){
                    q.add(next);
                    check[next] = check[parent]+1;
                    if(next == destination){
                        stop = true;
                    }
                }
            }
        }
    }
}

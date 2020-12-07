package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StartLink_5014 {
    static int f,s,g,u,d;
    static int[] check;
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        check[s] = 0;
        while (!q.isEmpty()){
            int floor = q.remove();
            if(floor == g) return;
            int up_floor = floor+u;
            int down_floor = floor-d;

            if(up_floor <= f && check[up_floor] == -1){
                q.add(up_floor);
                check[up_floor] = check[floor]+1;
            }

            if(down_floor > 0 && check[down_floor] == -1){
                q.add(down_floor);
                check[down_floor] = check[floor]+1;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        f = sc.nextInt();
        s = sc.nextInt();
        g = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        check = new int[f+1];
        Arrays.fill(check, -1);

        bfs();

        if(check[g] == -1){
            System.out.println("use the stairs");
        }else{
            System.out.println(check[g]);
        }
    }
}

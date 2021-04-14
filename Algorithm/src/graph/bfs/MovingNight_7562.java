package graph.bfs;

import java.util.*;

public class MovingNight_7562 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int testCnt = sc.nextInt();

        while (testCnt > 0){
            int n = sc.nextInt();
            int[][] check = new int[n][n];

            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int desX = sc.nextInt();
            int desY = sc.nextInt();

            if(startX != desX || startY != desY){
                bfs(check, startX, startY, n);
            }


            int ans = check[desX][desY];

            System.out.println(ans);

            testCnt -- ;
        }

    }

    public static void bfs(int[][] check, int startX, int startY, int n){
        int[] lx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] ly = {-1, -2, -2, -1, 1, 2, 2, 1};
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();
        qx.add(startX);
        qy.add(startY);

        while(!qx.isEmpty() && !qy.isEmpty()){
            int nowX = qx.remove();
            int nowY = qy.remove();

            for(int i=0; i<8; i++){
                int nextX = nowX + lx[i];
                int nextY = nowY + ly[i];
                if(nextX >=0 && nextX < n && nextY >= 0 && nextY < n){
                    if(check[nextX][nextY] == 0){
                        qx.add(nextX);
                        qy.add(nextY);
                        check[nextX][nextY] = check[nowX][nowY] + 1;
                    }
                }
            }
        }

    }
}

package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze_2178 {
    static int x;
    static int y;
    static int[][] maze;
    static int[][] check;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt();
        y = sc.nextInt();

        maze  = new int[x+1][y+1];
        check = new int[x+1][y+1];

        String blank = sc.nextLine();

        for(int i=1; i<x+1; i++) {
            String line = sc.nextLine();
            char[] aChar = line.toCharArray();
            for(int j=1; j<y+1; j++) {
                int num = Character.getNumericValue(aChar[j-1]);
                maze[i][j] = num;
            }
        }

        int cnt = 1;
        int ans = bfs(1, 1);

        System.out.println(ans);

    }

    public static int bfs(int r, int c) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        check[r][c] = 1;
        qx.add(r);
        qy.add(c);

        int ans = 0;

        while(true) {
            boolean change = false;
            r = qx.peek();
            c = qy.peek();

            if(r == x && c == y) {
                break;
            }

            //상
            if(r-1 >= 0) {
                if(maze[r-1][c] == 1 && check[r-1][c] == 0) {
                    check[r-1][c] = check[r][c]+1;
                    qx.add(r-1);
                    qy.add(c);
                    ans = check[r][c]+1;
                }
            }

            //하
            if(r+1 < x+1) {
                if(maze[r+1][c] == 1 && check[r+1][c] == 0) {
                    check[r+1][c] = check[r][c]+1;
                    qx.add(r+1);
                    qy.add(c);
                    ans = check[r][c]+1;
                }
            }

            //좌
            if(c-1 >= 0) {
                if(maze[r][c-1] == 1 && check[r][c-1] == 0) {
                    check[r][c-1] = check[r][c]+1;
                    qx.add(r);
                    qy.add(c-1);
                    ans = check[r][c]+1;
                }
            }

            //우
            if(c+1 < y+1) {
                if(maze[r][c+1] == 1 && check[r][c+1] == 0) {
                    check[r][c+1] = check[r][c]+1;
                    qx.add(r);
                    qy.add(c+1);
                    ans = check[r][c]+1;
                }
            }

            qx.remove();
            qy.remove();


        }

        return ans;

    }
}


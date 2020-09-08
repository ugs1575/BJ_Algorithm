package bruteforce.recursion;

import java.util.Scanner;
//정답을 찾은 경우 : 상하좌우 더이상 갈곳이 없으면
//불가능한 경우 : 한번 지나온 칸을 다시 가는 경우
public class Alphabet_1987 {
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static boolean[] check;
    static boolean[][] visit;
    static int r, c, max;
    static char[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        arr = new char[r][c];
        check = new boolean[26];
        visit = new boolean[r][c];

        max = Integer.MIN_VALUE;
        sc.nextLine();
        for(int i=0; i<r; i++){
            String input = sc.nextLine();
            for(int j=0; j<c; j++){
                arr[i][j] = input.charAt(j);
                if(i == 0 && j == 0){
                    int num = arr[i][j] - 'A';
                    check[num] = true;
                }
            }
        }
        visit[0][0] = true;
        go(0, 0, 1);
        System.out.println(max);
    }

    public static boolean isOut(int x, int y){
        return x < 0 || x >= r || y < 0 || y >= c;
    }

    public static void go(int x, int y, int move){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            //System.out.println("xx: "+nx+"yy : "+ny);
            if(!isOut(nx,ny) && !visit[nx][ny]){
                int alpa = arr[nx][ny]-'A';
                //System.out.println(alpa);
                if(check[alpa]){
                    continue;
                }
                //System.out.println(nx+" / "+ny);
                check[alpa] = true;
                visit[nx][ny] = true;
                go(nx, ny, move+1);
                check[alpa] = false;
                visit[nx][ny] = false;
            }
        }
        //System.out.println("end");
        if(move > max){
            max = move;
        }

        return;
    }



}

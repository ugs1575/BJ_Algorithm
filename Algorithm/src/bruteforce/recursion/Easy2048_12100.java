/*
* 문제 이해를 잘 못함 .. 이동 한번에 합쳐진 것은 또 합치지 못한다 라는 뜻이었음
* array 복사 문제 -> clone 하지 말자..
* */

package bruteforce.recursion;

import java.util.Scanner;

class Pair2{
    int x, y;
    boolean merge;
    Pair2(int x, int y, boolean merge){
        this.x = x;
        this.y = y;
        this.merge = merge;
    }
}

public class Easy2048_12100 {
    static int n;
    static int[] dx = {-1,0,0,1}; //위,왼,오,아
    static int[] dy = {0,-1,1,0};

    static void print_array(int[][] a){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int go(int[][] a, int move, int max, int direction){
        print_array(a);
        System.out.println("move : "+move+" / max :"+max+" / d : "+direction);
        int ans = 0;
        if(move > 5){
            return max;
        }

        boolean[][] check = new boolean[n][n];
        if(direction == 3){ //아래
            for(int i=n-1; i>=0; i--){
                for(int j=0; j<n; j++){
                    if(a[i][j] == 0) continue;
                    int ox = i;
                    int oy = j;
                    int nx = 0;
                    int ny = 0;
                    while (true){
                        nx = ox+dx[direction];
                        ny = oy+dy[direction];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= n) break;
                        if(a[ox][oy] == a[nx][ny] && !check[ox][oy] && !check[nx][ny]){
                            check[nx][ny] = true;
                            a[nx][ny] = a[ox][oy] * 2;
                            a[ox][oy] = 0;
                            max = Math.max(a[nx][ny], max);
                        }else if(a[nx][ny] == 0){
                            a[nx][ny] = a[ox][oy];
                            a[ox][oy] = 0;
                        }

                        ox = nx;
                        oy = ny;

                    }
                }
            }

        }else if(direction == 2){ //오른쪽
            for(int i=0; i<n; i++){
                for(int j=n-1; j>=0; j--){
                    if(a[i][j] == 0) continue;
                    int ox = i;
                    int oy = j;
                    int nx = 0;
                    int ny = 0;
                    while (true){
                        nx = ox+dx[direction];
                        ny = oy+dy[direction];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= n) break;
                        if(a[ox][oy] == a[nx][ny] && !check[ox][oy] && !check[nx][ny]){
                            check[nx][ny] = true;
                            a[nx][ny] = a[ox][oy] * 2;
                            a[ox][oy] = 0;
                            max = Math.max(a[nx][ny], max);
                        }else if(a[nx][ny] == 0){
                            a[nx][ny] = a[ox][oy];
                            a[ox][oy] = 0;
                        }

                        ox = nx;
                        oy = ny;

                    }
                }
            }
        }else{
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(a[i][j] == 0) continue;
                    int ox = i;
                    int oy = j;
                    int nx = 0;
                    int ny = 0;
                    while (true){
                        nx = ox+dx[direction];
                        ny = oy+dy[direction];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= n) break;
                        if(a[ox][oy] == a[nx][ny] && !check[ox][oy] && !check[nx][ny]){
                            check[nx][ny] = true;
                            a[nx][ny] = a[ox][oy] * 2;
                            a[ox][oy] = 0;
                            max = Math.max(a[nx][ny], max);
                        }else if(a[nx][ny] == 0){
                            a[nx][ny] = a[ox][oy];
                            a[ox][oy] = 0;
                        }

                        ox = nx;
                        oy = ny;

                    }
                }
            }
        }

        print_array(a);

        for(int i=0; i<4; i++){
            int[][] a2 = new int[n][n];
            for(int row=0; row<n; row++){
                for(int col=0; col<n; col++){
                    a2[row][col] = a[row][col];
                }
            }
            int res = go(a2, move+1, max, i);
            ans = Math.max(res, ans);

        }

        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] map = new int[n][n];
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
                max = Math.max(map[i][j], max);
            }
        }

        int ans = 0;
        for(int i=0; i<4; i++){
            int[][] a = new int[n][n];
            for(int row=0; row<n; row++){
                for(int col=0; col<n; col++){
                    a[row][col] = map[row][col];
                }
            }
            int res = go(a, 1, max, i);
            ans = Math.max(res, ans);
            System.out.println("************************");
        }

        System.out.println(ans);
    }
}

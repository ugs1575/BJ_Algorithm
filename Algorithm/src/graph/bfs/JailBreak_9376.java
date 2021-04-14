/*
* 알고리즘은 아래와 같이 세 가지 경우를 생각하면 됩니다.
* 1. 죄수 1이 죄수 2를 데리고 바깥으로 나가는 경우
* 2. 죄수 2가 죄수 1을 데리고 바깥으로 나가는 경우
* 3. 상근이가 죄수 1, 2를 찾으로 잠입하는 경우
* 따라서, 3명이 각자 탐색하다가 한 지점에 만날 경우 탈출을 했다고 봐도 무방합니다.
*
* 가능한한 모든 만나는 지점을 조사해 값을 더한뒤 가장 작은 값이 정답
* 만나는 지점이 문인경우 세사람이 모두 열고 지나간것 으로 는카운트 되므로 -2를 하여 한번만 여는 것으로 처리해야한다*
*
* 상근이가 밖에서 안으로 들어와야하므로 주어진 입력 MAP을 확장해주는 작업이 필요하다.
* 예를 들면 입력이(입력이 이럴순 없겟지만 예를들어서)
    ###
    ###
    ###
라고 하면,

. . . . .
. # # # .
. # # # .
. # # # .
. . . . .

이런 식으로 확장을 해야 한다.
*
*
* 이문제에서 가중치는 거리가 아닌 문을 연 횟수이다
* 큐를 사용할 경우 문을 연 횟수가 적은 것 부터 위로오게 해야하기 때문에
* 여기서는 덱을 사용하여
* 문을 열었을때는 addlast
* 안열었을 때 addfirst
*
* */

package graph.bfs;

import java.util.*;

class Pair5{
    int x, y;
    Pair5(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class JailBreak_9376 {
    static int h,w;
    static char[][] a;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static void bfs(int x, int y, int[][] check){
        for(int i=0; i<h+2; i++){
            for(int j=0; j<w+2; j++){
                check[i][j] = -1;
            }
        }
        ArrayDeque<Pair5> deque = new ArrayDeque<>();
        deque.add(new Pair5(x, y));
        check[x][y] = 0;
        while (!deque.isEmpty()){
            Pair5 p = deque.poll();
            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx < 0 || nx >= h+2 || ny < 0 || ny >= w+2) continue;
                if(a[nx][ny] == '*') continue;
                if(check[nx][ny] >= 0) continue;
                if(a[nx][ny] == '#') {
                    check[nx][ny] = check[p.x][p.y] + 1;
                    deque.addLast(new Pair5(nx, ny));
                }else {
                    check[nx][ny] = check[p.x][p.y];
                    deque.addFirst(new Pair5(nx, ny));
                }

            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            h = sc.nextInt();
            w = sc.nextInt();
            a = new char[h+2][w+2];

            for(int i=0; i<h+2; i++){
                for(int j=0; j<w+2; j++){
                    a[i][j] = '.';
                }
            }

            int x1 = -1;
            int y1 = -1;
            int x2 = -1;
            int y2 = -1;
            for(int i=1; i<=h; i++){
                String s = sc.next();
                for(int j=1; j<=w; j++){
                    a[i][j] = s.charAt(j-1);
                    if(a[i][j] == '$'){
                        if(x1 == -1){
                            x1 = i;
                            y1 = j;
                        }else{
                            x2 = i;
                            y2 = j;
                        }
                    }
                }
            }

            int[][] check0 = new int[h+2][w+2];
            int[][] check1 = new int[h+2][w+2];
            int[][] check2 = new int[h+2][w+2];
            bfs(0, 0, check0);
            bfs(x1, y1, check1);
            bfs(x2, y2, check2);

            int ans = h*w;
            for(int i=0; i<h+2; i++){
                for(int j=0; j<w+2; j++){
                    if(a[i][j] == '*') continue;
                    int cnt = check0[i][j]+check1[i][j]+check2[i][j];
                    if(a[i][j] == '#'){
                        cnt -= 2;
                    }
                    if(ans > cnt) ans = cnt;
                }
            }
            System.out.println(ans);
        }
    }
}

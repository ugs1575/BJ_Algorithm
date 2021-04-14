/*
*
* 52줄부터 시작된 2중for문은 (0,0)부터(n-1,m-1)까지 모든 점들에 대해서 bfs를 돌립니다.
* 하지만 앞의점에서 이미 지금의 점을 방문했다면, 지금의 점은 bfs를 돌릴 필요가 없지 않을까요?
* 예를들어 (0,0)에서 (0,1)을지나 25000정도의 길을 거쳐 미로를 탈출했다면, (0,1)은 다시 25000 여 번의 bfs서칭 없이도, 이미(0,0)에서 지금의 점을
* 방문했다는 점만 안다면 불필요한 bfs 서칭 시간을 줄일 수 있습니다.
* 더불어 이러한 방문체크를 로그의시간으로 해결한다면 문제를 해결하실 수 있습니다.
*
*
* 먼저, 모든좌표에서 주어진 방향에 맞게 따라가면서 하나하나 탐색을 하게 되면 시간초과가 발생하게 된다.
* 최악의 경우, 500 x 500 크기의 맵에서 500 x 500 만큼의 탐색을 해야 할 수도 있기 때문이다.
* 따라서 250000 x 250000 번의 탐색은 제한시간인 1초 내에 들어올 수가 없다.
* 그래서 본인은 메모이제이션을 사용했다.
* DFS + DP를 이용해서 풀었는데, 이를 풀기위해서 int DP[][] 라는 배열을 만들어 주었다.
* DP 배열에는 -1, 0, 1 3개의 값만을 저장해주었는데
* DP[a][b] = -1 의 의미는 "아직 (a, b)에서는 탐색을 안해봤으니 탐색을 해봐야 합니다" 를 의미하고
* DP[a][b] = 0 의 의미는 "(a, b)를 탐색해 봤는데, (a, b)에서는 밖으로 나갈 수 없습니다." 를 의미하고
* DP[a][b] = 1 의 의미는 "(a, b)를 탐색해 봤는데, (a, b)에서는 밖으로 나갈 수 있습니다." 를 의미한다.
* 즉, 초기에는 모든 DP배열의 값이 -1로 초기화 되어있고, DFS로 탐색을 진행하면서 DP배열의 값이 -1이 아니라면
* 그대로 DP배열의 값 그대로 return을 시켜줌으로써 중복된 탐색을 없애주었다.
*
*
* */
package bruteforce.etc;

import java.io.*;

public class EscapingMaze_17090 {
    static int n, m;
    static char[][] maze;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int dfs(int x, int y, int[][] dp){
        if(x < 0 || x >= n || y < 0 || y >= m) return 1;
        if(dp[x][y] != -1) return dp[x][y];

        char c = maze[x][y];
        int d = 0;
        if(c == 'R'){
            d = 1;
        }else if(c == 'D'){
            d = 2;
        }else if(c == 'L'){
            d = 3;
        }
        dp[x][y] = 0;
        dp[x][y] = dfs(x+dx[d], y+dy[d], dp);

        return dp[x][y];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        maze = new char[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                maze[i][j] = str.charAt(j);
            }
        }

        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = -1;
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                cnt += dfs(i, j, dp);
            }
        }

        System.out.println(cnt);

    }
}

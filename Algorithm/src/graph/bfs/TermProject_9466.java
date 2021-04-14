package graph.bfs;/*
이 문제 결국 못풀고 백준님의 코드를 참고했다..
start정점을 매개변수로 주는 것까지는 생각했는데
사이클에 포함된 갯수를 카운팅 하는건 도저히.. 모르겠더라
정답은 다시 돌아온 그 정점까지의 총 갯수에서
그 정점을 방문했을 때 저장한 cnt를 빼면 된다.
*/


import java.util.*;

public class TermProject_9466 {
    static int[] check; //방문함을 체크함과 동시에 cnt를 저장한다
    static int[] start; //어디서부터 시작 되었는지
    static int[] aList;
    static int ans; //사이클에 포함된 정점의 갯수

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            ans = 0;
            int n = sc.nextInt();
            check = new int[n+1];
            start = new int[n+1];
            aList = new int[n+1];
            for(int j=1; j<=n; j++){
                int studentNum = sc.nextInt();
                aList[j] = studentNum;
            }

            for(int j=1; j<=n; j++){
                if(check[j] == 0){
                    ans += dfs(j, 1, j);
                }
            }

            System.out.println(n-ans);
        }
    }

    public static int dfs(int node, int cnt, int step){
        //만약, 방문했던 정점이라면
        if(check[node] != 0){
            //시작이 다르면 0을 리턴
            if(start[node] != step){
                return 0;
            }
            //시작이 같으면 총 갯수에서 멈춘 그 정점의 cnt를 빼줌
            return cnt-check[node];
        }
        //처음 방문하는 것이라면
        //check배열에 cnt를 저장
        //cnt는 1부터 시작해 정점을 방문할 때 마다 하나씩 늘어난다
        check[node] = cnt;
        //동시에 시작했던 정점 번호도 함께 저장
        start[node] = step;
        return dfs(aList[node], cnt+1, step);

    }
}

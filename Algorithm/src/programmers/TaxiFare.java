package programmers;

public class TaxiFare {
    static final int inf = 1000000000;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] d = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i == j) d[i][j] = 0;
                else d[i][j] = inf;
            }
        }

        int min = inf;
        for(int i=0; i<fares.length; i++){
            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];
            d[from][to] = cost;
            d[to][from] = cost;
            if(from == s && to == a || from == s && to == b
                || from == a && to == s || from == b && to == s){
                min += cost;
            }
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(d[i][j] > d[i][k]+d[k][j]){
                        d[i][j] = d[i][k]+d[k][j];
                    }
                }
            }
        }

        if(d[s][a]+d[s][b] < min){
            min = d[s][a]+d[s][b];
        }

        if(d[s][a]+d[a][b] < min){
            min = d[s][a]+d[a][b];
        }

        if(d[s][b]+d[b][a] < min){
            min = d[s][b]+d[b][a];
        }


        for(int i=1; i<=n; i++){
            if(i == s || i == a || i == b) continue;
            if(d[s][i] == inf || d[i][a] == inf || d[i][b] == inf) continue;
            if(d[s][i]+d[i][a]+d[i][b] < min){
                min = d[s][i]+d[i][a]+d[i][b];
            }

        }

        return min;
    }
    public static void main(String[] args) {
        int n = 7;
        int s = 3;
        int a = 4;
        int b = 1;
        int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
        TaxiFare t = new TaxiFare();
        System.out.println(t.solution(n,s,a,b,fares));
    }
}

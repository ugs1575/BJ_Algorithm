package divideConquer;

import java.io.*;

public class RepresentationOfSet_1717 {
    static int[] parent, rank;
    static int find(int s){
        if(s == parent[s]){
            return s;
        }else{
            return parent[s] = find(parent[s]);
        }
    }
    static void union(int s1, int s2){
        int x = find(s1);
        int y = find(s2);
        if(x == y) return;
        if(rank[x] < rank[y]){
            int temp = y;
            y = x;
            x = temp;
        }
        parent[y] = x;
        if(rank[x] == rank[y]){
            rank[x] = rank[y]+1;
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        String[] a = br.readLine().split(" ");
        int n = Integer.parseInt(a[0]);
        int m = Integer.parseInt(a[1]);
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<m; i++){
            a = br.readLine().split(" ");
            int op = Integer.parseInt(a[0]);
            int s1 = Integer.parseInt(a[1]);
            int s2 = Integer.parseInt(a[2]);
            if(op == 0){
                //합집합
                union(s1, s2);
            }else{
                //같은 집합 포함 여부 확인
                if(find(s1) == find(s2)){
                    bw.write("YES\n");
                }else{
                    bw.write("NO\n");
                }
            }
        }
        bw.flush();
    }
}

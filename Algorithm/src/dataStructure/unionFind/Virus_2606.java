/*
* 컴퓨터 1도 누군가의 자식이 될 수 있기때문에
* 마지막 확인하는 부분에서 find연산으로 수행해서 찾아야한다.
*
* */

package dataStructure.unionFind;

import java.io.*;

public class Virus_2606 {
    static int[] parent;
    static int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            return parent[x] = find(parent[x]);
        }
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            parent[y] = x;
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cpt = Integer.parseInt(br.readLine());
        int cnct = Integer.parseInt(br.readLine());
        parent = new int[cpt+1];
        for(int i=0; i<=cpt; i++){
            parent[i] = i;
        }
        for(int i=0; i<cnct; i++){
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            union(x, y);
        }

        int ans = 0;
        for(int i=2; i<=cpt; i++){
            System.out.println(i+"/"+parent[i]);
            if(find(i) == find(1)) {
                ans += 1;
            }
        }

        System.out.println(ans);

    }
}

package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Emoji_14226 {
    static int[][] check = new int[1001][1001];
    static int cnt;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        cnt = sc.nextInt();

        int ans = bfs(1,1,1);

        System.out.println(ans);

    }

    public static int bfs(int screen, int clip, int sec){
        Queue<Integer> qs = new LinkedList<Integer>();
        Queue<Integer> qc = new LinkedList<Integer>();

        check[screen][clip] = sec;
        qs.add(screen);
        qc.add(clip);

        while(true){
            int s = qs.remove();
            int c = qc.remove();
            int[] aScreen = {s, s+c, s-1};
            int[] aClip = {s, c, c};

            for(int i=0; i<3; i++){
                if(aScreen[i] != 0 && aScreen[i] <= 1000 && aClip[i] <= 1000 && check[aScreen[i]][aClip[i]] == 0){
                    check[aScreen[i]][aClip[i]] = check[s][c] + 1;
                    qs.add(aScreen[i]);
                    qc.add(aClip[i]);

                    if(aScreen[i] == cnt){
                        return check[aScreen[i]][aClip[i]];
                    }
                }
            }
        }

    }
}

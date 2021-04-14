/*
* Q1689_겹치는 선분과 같은 문제이다.
* 겹치는 선분을 풀었던 방식과 동일하게 풀되
* 0 -> 1 되는 순간은 선이 시작하는 부분이고
* 1 -> 0 되는 순간은 선이 끝나는 부분임을 알 수 있다.
* 시작하는 부분과 끝나는 부분의 길이 를 계산해서 길이를 구할 수 있다.
*
* */
package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Pair3 implements Comparable<Pair3>{
    int first, second;
    Pair3(int first, int second){
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair3 that) {
        if(this.first < that.first){
            return -1;
        }else if(this.first == that.first){
            if(this.second < that.second){
                return -1;
            }else if(this.second == that.second){
                return 0;
            }else{
                return 1;
            }
        }else{
            return 1;
        }
    }
}

public class DrawingLine_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Pair3> alist = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            alist.add(new Pair3(x, 1));
            alist.add(new Pair3(y, -1));
        }

        Collections.sort(alist);
        int cnt = 0;
        int start = 0;
        int end = 0;
        int ans = 0;
        for(Pair3 p : alist){
            if(cnt == 0 && p.second == 1){
                start = p.first;
            }

            if(cnt == 1 && p.second == -1){
                end = p.first;
                ans += end-start;
            }

            cnt += p.second;
        }

        System.out.println(ans);
    }
}

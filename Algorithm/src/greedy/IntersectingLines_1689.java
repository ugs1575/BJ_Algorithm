/*
* Q1931_회의실배정 문제와 유사한 문제이다.
*
* 이 문제를 회의 스케줄이 주어지고 필요한 최소한의 회의실을 구하는 문제로 바꿔볼 수 있다.
*
* 선분은 점 2개로 이루어져 있고, 시작점과 끝점을 나누어서
* 시작점을 만나면 +1
* 끝점을 만나면 -1을 해주면 된다.
*
* 이때 주의할 점이 있는데, 만약 시작점과 끝점이 만나는 것을 교차로 본다고 하면
* 시작점을 먼저 계산해주어야 한다.
*
* 아니면 끝점을 먼저 계산해주어야 한다.
*
* */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Pair2 implements Comparable<Pair2>{
    int first, second;
    Pair2(int first, int second){
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair2 that) {
        if(this.first < that.first){
            return -1;
        }else if(this.first == that.first){ //시작점과 끝점이 같으면 끝점을 우선으로
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

public class IntersectingLines_1689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Pair2> a = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            a.add(new Pair2(x, 1));
            a.add(new Pair2(y, -1));
        }
        Collections.sort(a);
        int ans = 0;
        int cnt = 0;
        for(Pair2 p : a){
            cnt += p.second;
            if(cnt > ans) ans = cnt;
        }
        System.out.println(ans);
    }
}

package programmers;

import java.util.Arrays;

class Pair3 implements Comparable<Pair3>{
    int stage;
    double ratio;
    Pair3(int stage, double ratio){
        this.stage = stage;
        this.ratio = ratio;
    }

    @Override
    public int compareTo(Pair3 that) {
        if(this.ratio > that.ratio){
            return -1;
        }else if(this.ratio == that.ratio){
            if(this.stage < that.stage){
                return -1;
            }else if(this.stage == that.stage){
                return 0;
            }else{
                return 1;
            }
        }else {
            return 1;
        }
    }
}

public class FailRatio{
    public int[] solution(int N, int[] stages) {
        int[] notClearPlayers = new int[N+2];
        int[] clearPlayers = new int[N+2];
        for(int s:stages){
            notClearPlayers[s] += 1;
        }
        for(int i=1; i<=N; i++){
            for(int j=N+1; j>=i; j--){
                clearPlayers[i] += notClearPlayers[j];
            }
        }

        Pair3[] arr = new Pair3[N];
        for(int i=1; i<=N; i++){
            if(clearPlayers[i] == 0) {
                arr[i-1] = new Pair3(i, 0.0);
            }
            else{
                double ratio = (double)notClearPlayers[i]/(double)clearPlayers[i];
                arr[i-1] = new Pair3(i, ratio);
            }
        }

        Arrays.sort(arr);

        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            answer[i] = arr[i].stage;
        }


        return answer;
    }
    public static void main(String[] args) {
        FailRatio f = new FailRatio();
        int N = 4;
        int[] stages = {4,4,4,4,4};
        System.out.println(f.solution(N, stages));
    }


}

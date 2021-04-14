package programmers;

import java.util.*;

public class Programming {
    static int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] period = new int[n];
        for(int i=0; i<n; i++){
            int day = (100 - progresses[i])/speeds[i];
            int mod = (100 - progresses[i])%speeds[i];
            if(mod > 0) day += 1;
            period[i] = day;
        }

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(q.isEmpty()){
                q.add(period[i]);
            }else{
                if (q.peek() < period[i]){
                    list.add(q.size());
                    q.clear();
                }
                q.add(period[i]);
            }
        }

        while (!q.isEmpty()){
            list.add(q.size());
            q.clear();
        }

        int m = list.size();
        int[] answer = new int[m];
        for(int i=0; i<m; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        solution(progresses, speeds);
    }
}

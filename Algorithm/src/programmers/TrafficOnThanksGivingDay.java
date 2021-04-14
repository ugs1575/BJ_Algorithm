//https://yabmoons.tistory.com/564

package programmers;

import java.util.ArrayList;
import java.util.Collections;

class Pair2 implements Comparable<Pair2>{
    int time, isEnd;
    Pair2(int time, int isEnd){
        this.time = time;
        this.isEnd = isEnd; // start : 0, end : 1
    }

    @Override
    public int compareTo(Pair2 that) {
        if(this.time < that.time){
            return -1;
        }else if(this.time == that.time){
            if(this.isEnd < that.isEnd){
                return -1;
            }else if(this.isEnd == that.isEnd){
                return 0;
            }else{
                return 1;
            }
        }else{
            return 1;
        }
    }
}

class TrafficOnThanksGivingDay {
    static int solution(String[] line) {
        ArrayList<Pair2> list = new ArrayList<Pair2>();
        for(String s : line){
            //ms로 바꾸기
            String[] log = s.split(" ");
            String[] time = log[1].split(":");
            int hh = Integer.parseInt(time[0]) * 60 * 60 * 1000;
            int mm = Integer.parseInt(time[1]) * 60 * 1000;
            int ss = (int) (Double.parseDouble(time[2]) * 1000.0);
            int wastedTime = (int) (Double.parseDouble(log[2].replace("s","")) * 1000.0);

            int endTime = hh + mm + ss;
            int startTime = endTime - wastedTime + 1;
            endTime += 999;

            list.add(new Pair2(startTime, 0));
            list.add(new Pair2(endTime, 1));
        }

        Collections.sort(list);
        int answer = 0;
        int traffic = 0;
        for(Pair2 p : list){
            if(p.isEnd == 0){
                traffic += 1;
            }else{
                traffic -= 1;
            }

            if(traffic > answer) answer = traffic;
        }
        return answer;

    }
    

    public static void main(String[] args) {
        String[] line = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
};

        System.out.println(solution(line));
    }

}


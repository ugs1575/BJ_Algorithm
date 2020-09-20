/*
* 기준을 어떻게 세울것인가?
* 1. 일찍 시작하는 회의를 배정한다 -> x
* 일찍 시작해도 회의 시간이 길수도 있으니
*
* 2.짧은 회의를 먼저 배정한다 -> x
* 회의 시간이 짧다 해서 시간이 어중간 하게 (5-7)에 있어버리면
* 나머지 그 시간에 겹치는 긴 회의가 두가지 있다고 하면 한개만 배정할수 밖에 없다
*
* 3. 끝나는 시간이 빠른 회의를 먼저 배정 한다 -> o
* 끝나는 시간이 빠르다는 것은 그 만큼 더 많은 회의를 배정할 수 있다* */

package greedy;

import java.util.*;

class Meeting implements Comparable<Meeting>{
    int start, end;
    Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting that) {
        if(this.end < that.end){
            return -1;
        }else if(this.end == that.end){ //끝나는 시간이 같으면 시작시간이 먼저인것 으로 배
            if(this.start < that.start){
                return -1;
            }else if(this.start == that.start){
                return 0;
            }else{
                return 1;
            }
        }else{
            return 1;
        }
    }
}

public class MeetingRoom_1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Meeting[] a = new Meeting[n];

        for(int i=0; i<n; i++){
            int st = sc.nextInt();
            int et = sc.nextInt();
            a[i] = new Meeting(st, et);
        }
        Arrays.sort(a);
        int max = -1;
        int ans = 0;
        for(int i=0; i<n; i++){
            if(max <= a[i].start){
                max = a[i].end;
                ans += 1;
            }
        }

        System.out.println(ans);

    }
}

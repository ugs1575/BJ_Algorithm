/*
* (전체 크기) - (한 패턴 직사각형 당 사용하지 못하는 정사각형 크기 * 반복횟수)
* (w * h) - (((w / 최대공약수) + (h / 최대공약수) - 1) * 최대공약수)
* */

package programmers;

public class Rectangle_ans {
    static int gcd(int w, int h){
        if(h == 0) return w;
        return gcd(h, w%h);
    }
    static long solution(int w, int h) {
        /*if(w < h) {
            int temp = h;
            h = w;
            w = temp;
        }*/

        long gcd = gcd(w, h);
        long answer = ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
        return answer;
    }

    public static void main(String[] args) {
        int w = 100000000;
        int h = 100000000;

        System.out.println(solution(w,h));
    }
}

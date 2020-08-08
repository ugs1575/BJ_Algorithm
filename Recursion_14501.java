package bruteforce.recursion;

import java.util.Scanner;

public class Recursion_14501 {
    static int n, maxPay;
    static int[] aDay, aPay;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        maxPay = 0;
        aDay = new int[n+1];
        aPay = new int[n+1];

        for(int i=1; i<=n; i++){
            aDay[i] = sc.nextInt();
            aPay[i] = sc.nextInt();
        }

        go(1, 0);


        System.out.println(maxPay);

    }

    public static void go(int day, int pay){
        //정답을 찾은 경우
        //문제좀 잘 읽자  백준이는 n+1일째에 퇴사를 하고싶어한다.
        if(day == n+1){
            if(maxPay < pay) maxPay = pay;
            return;
        }

        //불가능한 경우
        if(day > n+1){
            return;
        }



        go(day+aDay[day], pay+aPay[day]);
        go(day+1, pay);
    }
}

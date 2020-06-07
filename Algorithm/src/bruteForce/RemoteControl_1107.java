package bruteforce;

import java.util.Scanner;

public class RemoteControl_1107 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean[] numBtn = new boolean[10];
        int brokenCnt = sc.nextInt();

        //고장난 버튼에는 true를 넣어줌
        for(int i=0; i<brokenCnt; i++){
            numBtn[sc.nextInt()] = true;
        }

        //+,-로만 이동하는 횟수
        int ans = Math.abs(n-100);

        //숫자버튼을 눌러 다른 채널로 이동한후 +, -로 이동하는 경우
        //0 ~ 1000000 까지 모든 채널을 검사해
        for(int i=0; i<1000000; i++){
            int c = i;
            //이동할 수 있으면
            int numPress = canMove(c, numBtn);
            //다른채널로 이동후 그 채널에서 +, -버튼을 누르는 횟수
            int press = Math.abs(n - c);

            //오로지 +, - 버튼만 눌러 이동하는 것보다 적게 누르면 ans에 값을 넣어준다
            if(numPress > 0){
                if(ans > numPress + press){
                    ans = numPress + press;
                }
            }
        }

        System.out.print(ans);


    }

    public static int canMove(int channel, boolean[] numBtn){
        String ch = String.valueOf(channel);

        for(int i=0; i<ch.length(); i++){
            int btn = Character.getNumericValue(ch.charAt(i));

            if(numBtn[btn]){
                return 0;
            }
        }

        return ch.length();

    }

}

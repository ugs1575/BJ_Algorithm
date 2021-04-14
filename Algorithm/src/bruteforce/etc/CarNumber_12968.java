package bruteforce.etc;

import java.util.Scanner;

public class CarNumber_12968 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        char last = s.charAt(0);
        int cnt = 1;
        if(last == 'd') cnt *= 10;
        if(last == 'c') cnt *= 26;
        for(int i=1; i<s.length(); i++){
            if(last == 'd'){
                if(s.charAt(i) == 'd'){
                    cnt *= 9;
                }else{
                    cnt *= 26;
                }
            }else{
                if(s.charAt(i) == 'c'){
                    cnt *= 25;
                }else{
                    cnt *= 10;
                }
            }
            last = s.charAt(i);
        }

        System.out.println(cnt);
    }
}

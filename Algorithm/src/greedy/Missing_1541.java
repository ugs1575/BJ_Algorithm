/*
* 최대한 -가 되게 만들어야함
* -가 나오면 그 뒤에 다시 -가 나올때 까지 그 수들을 묶어 버리면 최소가 됨
*
* */

package greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Missing_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] a = str.toCharArray();
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> sign = new ArrayList<>();
        sign.add(1);
        int n = 0;
        for(char i : a){
            if(i == '+' || i== '-'){
                if(i == '+'){
                    sign.add(1);
                }else{
                    sign.add(-1);
                }
                num.add(n);
                n = 0;
            }else{
                n = n * 10 + (i - '0');
            }
        }
        num.add(n);
        boolean minus = false;
        int ans = 0;
        for(int i=0; i<num.size(); i++){
            if(sign.get(i) == -1){
                minus = true;
            }

            if(minus){
                ans -= num.get(i);
            }else{
                ans += num.get(i);
            }
        }
        System.out.println(ans);
    }
}

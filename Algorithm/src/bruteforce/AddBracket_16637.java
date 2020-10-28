/*
* 괄호의 의미
* = 먼저 계산 한다
*
* 3+8*7-9*2에 괄호를 (3+8)*(7-9)*2로 친 것은 아래와 같이 변형해서 계산할 수 있다.
* 3 + 8 * 7 - 9 * 2
*  먼저     먼저
* 11 - 0 * -2 + 0 * 2
*
* 괄호 안에는 연산자가 하나만 들어 있어야하고, 중첩된 괄효는 사용할 수 없다
* => 먼저가 연속으로 나오면 안된
*
* */

package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

class Term{
    int num, op;
    Term(int num, int op){
        this.num = num;
        this.op = op; //1 = +, 2 = -, 3 = x
    }
}

public class AddBracket_16637 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        Term[] a = new Term[n];
        for(int i=0; i<n; i++){
            //숫자이면 op에 0을 넣어줌, 연산자이면 num에 0을 넣어줌
            if(i%2 == 0){
                a[i] = new Term(s.charAt(i)-'0', 0);
            }else{
                int op = 1;
                if(s.charAt(i) == '-'){
                    op = 2;
                }else if(s.charAt(i) == '*'){
                    op = 3;
                }

                a[i] = new Term(0, op);
            }
        }

        int ans = -2147483648;
        int m = (n-1)/2; //연산자 갯수
        for(int i=0; i<(1<<m); i++){ //모든 경우의 수 생성
            boolean ok = true;
            //먼저 연속 체크
            for(int j=0; j<m-1; j++){
                if((i&(1<<j)) > 0 && ((i&(1<<j+1)) > 0)){
                    ok = false;
                }
            }

            if(!ok) continue;
            Term[] b = new Term[n];
            for(int j=0; j<n; j++){
                b[j] = new Term(a[j].num, a[j].op);
            }
            for(int j=0; j<m; j++){
                if((i&(1<<j)) > 0){
                    int k = 2*j+1;
                    if(b[k].op == 1){
                        b[k-1].num += b[k+1].num;
                        b[k+1].num = 0;
                    }else if(b[k].op == 2){
                        b[k-1].num -= b[k+1].num;
                        b[k].num = 1; //+로 바꿔주기
                        b[k+1].num = 0;
                    }else{
                        b[k-1].num *= b[k+1].num;
                        b[k].num = 1; //+로 바꿔주기
                        b[k+1].num = 0;
                    }
                }
            }

            int res = b[0].num;
            for(int j=0; j<m; j++){
                int k = 2*j+1;
                if(b[k].op == 1){
                    res += b[k+1].num;
                }else if(b[k].op == 2){
                    res -= b[k+1].num;
                }else if(b[k].op == 3){
                    res *= b[k+1].num;
                }
            }

            if(ans < res){
                ans = res;
            }
        }

        System.out.println(ans);

    }
}

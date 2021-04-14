/*
* 괄호 추가하기 1과 다른점은 차례대로 계산하지 않고 x연산에 우선순위가 있다는 점이다
* 기존과 똑같이 풀면 예상과 다른 결과가 다르게 나오기 때문에 몇가지 추가할 점이 있다
* 예를들면
* 3 + 8 * 7 - 9 * 2
*  먼저     먼저
* 11 + 0 * -2 + 0 * 2  이렇게 되는데
* 답은 (3+8)*(7-9)*2 = -44인데
* 곱하기 연산이 우선이므로 11+0+0이 되어서 11이 된다.
*
* 1. 먼저 우선순위가 부여된 연산자에 기존에는 + 연산자로 바꿔 주었지만 대신 -1을 넣는다
* 차례로 연산하다 -1이 나오면 skip skip 한다
*
* 2. 곱하기 연산이 우선이 되어야하기 때문에
* 배열을 하나 더 만들어서(코드에서는 arraylist) 곱하기 연산의 경우
* 곱하기 연산을 해준 상태에서 넣어준다
*
* 그 뒤로 차례로 계산한다.
*
* */


package bruteforce.etc;

import java.util.ArrayList;
import java.util.Scanner;

public class AddBracket2_16638 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            if(i%2 == 0){
                arr[i] = s.charAt(i)-'0';
            }else{
                if(s.charAt(i) == '+'){
                    arr[i] = 1;
                }else if(s.charAt(i) == '-'){
                    arr[i] = 2;
                }else{
                    arr[i] = 3;
                }
            }
        }

        int ans = -2147483648;
        int m = (n-1)/2; //연산자 갯수
        for(int i=0; i<(1<<m); i++){
            boolean ok = true;
            for(int j=0; j<m-1; j++){
                if((i & (1<<j)) > 0 && (i & (1<<j+1)) > 0){
                    ok = false;
                    break;
                }
            }

            if(!ok) continue;

            //배열 복사
            int[] a = new int[n];
            for(int j=0; j<n; j++){
                a[j] = arr[j];
            }


            for(int j=0; j<m; j++){
                if((i & (1<<j)) > 0){
                    int k = 2*j+1;
                    if(a[k] == 1){
                        int temp = a[k-1]+a[k+1];
                        a[k-1] = temp;
                        a[k+1] = 0;
                        a[k] = -1;
                    }else if(a[k] == 2){
                        int temp = a[k-1]-a[k+1];
                        a[k-1] = temp;
                        a[k+1] = 0;
                        a[k] = -1;
                    }else{
                        int temp = a[k-1]*a[k+1];
                        a[k-1] = temp;
                        a[k+1] = 0;
                        a[k] = -1;
                    }
                }
            }

            ArrayList<Integer> alist = new ArrayList<>();
            for(int j=0; j<n; j++){
                if(j%2 == 0){
                    alist.add(a[j]);
                }else{
                    if(a[j] == -1){
                        j += 1;
                    }else{
                        if(a[j] == 3){
                            int num = alist.get(alist.size()-1) * a[j+1];
                            alist.remove(alist.size()-1);
                            alist.add(num);
                            j += 1;
                        }else{
                            alist.add(a[j]);
                        }
                    }
                }
            }

            int res = alist.get(0);
            for(int j=1; j<alist.size(); j+=2){
                if(alist.get(j) == 1){
                    res += alist.get(j+1);
                }else{
                    res -= alist.get(j+1);
                }
            }


            if(res > ans) ans = res;

        }


        System.out.println(ans);


    }
}

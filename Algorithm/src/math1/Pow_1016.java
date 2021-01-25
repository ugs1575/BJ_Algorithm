/*
* 에라토스테네스의 체를 활용하여 풀 수 있다.
* 제한이 너무 크다. 10^12 이다.
* 하지만 min과 max사이 크기 100만 정도이기 때문에
*
* 배열을 max와 min 차이값으로 설정하고
* min+i로 생각하며 문제를 푼다.
*
*
* 에라토스테네스의 체를 활용하여
* 2 부터 max까지 제곱의 배수를 없애준다.
*
* 이때 첫 스타트가 관건인데,
* 예를 들어 i=3, min=20인 경우를 살펴보자.
*
* 이때 첫 스타트는 27이 되어야할 것이다. 첫 숫자를 어떻게 구할 수 있을까?
* i의 제곱은 9이다.
* 나머지의 원리에 의해 보통 9로 나누어 떨어지는 숫자가 나오기 전까지는 1부터 8까지 나머지가 나올 것이다.
*
* min을 9로 나누면 나머지는 2이다. 그러면 9-2=7
* 20 + 7 = 27가 스타트가 된다.
*
*
* */
package Math;

import java.util.Scanner;
public class Pow_1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        boolean[] a = new boolean[(int)(max-min)+1];
        for(int i=2; i*i<=max; i++){
            long start = i*i-min%(i*i);
            if(start == i*i){
                start = 0;
            }

            while (start <= max-min){
                a[(int)start] = true;
                start+=i*i;
            }
        }

        int ans = 0;
        for(int i=0; i<=max-min; i++){
            if(a[i] == false){
                ans += 1;
            }
        }

        System.out.println(ans);

    }
}

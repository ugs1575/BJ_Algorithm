/*
* 삼각형의 닮음을 이용하면 c = h1-h2/h1+h2라는 식을 만들 수 있
* d가 커지만 c는 작아지고
* d가 작아지면 c는 커진다
*
* 실수에서 이분탐색을 수행하는 것이기 때문에, 변경해야 하는 부분이 있다
* while(left <= right) 와 같은 표현의 사용이 불가능하다
* left = mid+1 불가능(mid와 mid+1사이에 정답이 있을 수 있기 때문)
* right = mid-1 불가능(mid-1와 mid사이에 정답이 있을 수 있기 때문)
*
* 대신 아래와 같은 표현 중 하나를 사용한다
* for(int k=0; i<10000; k++)
* while(abs(right-left) > 1e-6)
*
*
* */

package divideConquer.binarySearch;

import java.util.*;

public class Ladder_2022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextDouble()){
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            double c = sc.nextDouble();
            double left = 0;
            double right = Math.min(x, y);
            for(int k=0; k<10000; k++){
                double mid = (left + right) / 2.0;
                double d = mid;
                double h1 = Math.sqrt(x*x-d*d);
                double h2 = Math.sqrt(y*y-d*d);
                double h = (h1*h2)/(h1+h2);
                if(h > c){
                    left = mid;
                }else{
                    right = mid;
                }
            }
            System.out.printf("%.3f\n", left);
        }
    }
}

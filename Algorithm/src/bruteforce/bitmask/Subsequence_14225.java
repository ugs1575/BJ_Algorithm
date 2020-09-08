package bruteforce.bitmask;
/*
* 위의 문제의 경우 같이 원소가 5개인 집합의 부분집합을 모두 검사한다고 해보자
* 일단 만약 원소가 5개라면 부분집합의 총 가짓수는 2^5 인 32가지가 될것 이다.
* 고로 변수 n개에 원소의 갯수가 저장되어있다고 하면
* 0부터 1<<n까지 검사를 하게된다.
* 그러니까 00000 ~ 11111까지 검사를 하는것이다.
* 여기서 1의 위치가 원소의 위치와 같다고 생각하면된다.
* 이렇게 위의 수를 하나씩 검사할 때 그 안에서 다음의 로직을 수행한다
* for(int j=0; j<n; j++){
*   if(i & (1<<j))
*       원하는 처리
*   }
* }
* 여기서 i는 00000 ~ 11111중 하나이다.
* 아무튼 이렇게 되면 i에대해 1이 위치하고 있는 자리의 원소를 자신이 원하는 대로 처리해줄 수 있게 되고
* 결과적으로 모든 부분수열에 대한 처리를 할 수 있다.
*
* */
import java.util.Scanner;

public class Subsequence_14225 {
    public static void main(String main[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        boolean[] check = new boolean[20*100000+1];

        for(int i=1; i<=(1<<n); i++){
            int sum = 0;
            for(int j=0; j<n; j++){
                if((i&(1<<j)) != 0){
                    sum += arr[j];
                }
            }
            check[sum] = true;
        }

        for(int i=0;;i++){
            if(!check[i]){
                System.out.println(i);
                break;
            }
        }
    }
}

package bruteforce.recursion;

import java.util.Scanner;

public class Recursion_1182 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int ans = go(arr, 0, s, 0);
        if(s == 0){ //아무것도 선택하지 않는 경우도 있으니 그럴경우 0 이므로 s 가 0일때는 무조건 -1 처리를 한다.
            ans -= 1;
        }

        System.out.println(ans);

    }

    public static int go(int[] arr, int index, int s, int sum){
        if(index == arr.length){
            if(sum == s){
                return 1;
            }else{
                return 0;
            }
        }

        return go(arr, index+1, s,sum+arr[index]) + go(arr, index+1, s, sum);

    }
}

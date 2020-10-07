/*
* b로 채웠을 때 사이사이 A를 껴 넣어준다
* 배열로 만들어 cnt[x] 는 들어가면 x만큼 세트가 생긴다는 뜻
*
* */


package greedy;

import java.util.Scanner;

public class AB_12970 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int a=0; a<=n; a++){
            int b = n-a;
            if(a*b < k) continue;
            int[] cnt = new int[b+1];
            for(int i=0; i<a; i++){
                int x = Math.min(b, k);
                cnt[x] += 1;
                k -= x;
            }

            for(int j=b; j>=0; j--){
                for(int t=0; t<cnt[j]; t++){
                    System.out.print('A');
                }
                if(j > 0){
                    System.out.print('B');
                }
            }

            System.out.println();
            System.exit(0);
        }
        System.out.println(-1);
    }
}

/*
* 돌출된 부분을 기준으로 값을 주고 전체 높이가 같은지 확인한다.
* ㄴ 도형이 있다고 하면 예제로 높이가 2,1로 주어질 것이다
* ㅓ 도형의 경우 돌출된 부분을 기준으로 높이를 확인봤을 때 밑으로 돌출된 칸이
* 0,1이다, 이렇게 한 후 높이와 이값을 더한다
* 2+0 = 1+1 같아야
*
* */

package bruteforce;

import java.util.*;

public class Tetris_3019 {
    static int c, p;
    static int[] height;
    static int solve(int[] a){
        int res = 0;
        boolean ok = true;
        for(int i=0; i+a.length<=c; i++){
            int gap = a[0]+height[i];
            for(int j=0; j<a.length; j++){
                if(a[j]+height[i+j] != gap){
                    ok = false;
                    break;
                }
            }
            if(ok){
                res += 1;
            }
            ok = true;
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        p = sc.nextInt();
        height = new int[c];
        for(int i=0; i<c; i++){
            height[i] = sc.nextInt();
        }

        int ans = 0;
        switch (p){
            case 1:
                ans += c + solve(new int[]{0,0,0,0});
                break;
            case 2:
                ans += solve(new int[]{0,0});
                break;
            case 3:
                ans += solve(new int[]{1,1,0})
                        +solve(new int[]{0,1});
                break;
            case 4:
                ans += solve(new int[]{1,0})
                        +solve(new int[]{0,1,1});
                break;
            case 5:
                ans += solve(new int[]{0,0,0})
                        +solve(new int[]{0,1})
                        +solve(new int[]{1,0})
                        +solve(new int[]{0,1,0});
                break;
            case 6:
                ans += solve(new int[]{0,0,0})
                        +solve(new int[]{0,0})
                        +solve(new int[]{1,0,0})
                        +solve(new int[]{0,2});
                break;
            case 7:
                ans += solve((new int[]{0,0,0}))
                        +solve(new int[]{2,0})
                        +solve(new int[]{0,0,1})
                        +solve(new int[]{0,0});
                break;
        }

        System.out.println(ans);
    }
}

/*
* pi[n-1]의 cnt값을 pi[pi[n-1]-1]의 cnt값을 더해주면 된다.. 포함되어 있으니까
* 그리고 답 출력할때는 마지막 suffix값이 포함 안되어있기 때문에 +1해준다.
*
* */

package stringMatching.kmp;

import java.util.ArrayList;
import java.util.Scanner;

public class PrefixAndSuffix_13576 {
    static int[] preprocessing(String s){
        int n = s.length();
        int[] pi = new int[n];
        pi[0] = 0;
        int j = 0;
        for(int i=1; i<n; i++){
            while (j>0 && s.charAt(i) != s.charAt(j)){
                j = pi[j-1];
            }
            if(s.charAt(i) == s.charAt(j)){
                pi[i] = j+1;
                j += 1;
            }else{
                pi[i] = 0;
            }
        }

        return pi;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int[] pi = preprocessing(s);
        int[] cnt = new int[n+1];
        for(int i=0; i<n; i++){
            cnt[pi[i]] += 1;
        }
        for(int i=n; i>0; i--){
            cnt[pi[i-1]] += cnt[i];
        }

        ArrayList<Integer> ans1 = new ArrayList<>();
        ArrayList<Integer> ans2 = new ArrayList<>();
        for(int i=n; i>0; i=pi[i-1]){
            ans1.add(i);
            ans2.add(cnt[i]+1);
        }

        int m = ans1.size();
        System.out.println(m);
        for(int i=m-1; i>=0; i--){
            System.out.println(ans1.get(i)+" "+ans2.get(i));
        }

    }
}

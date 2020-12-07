package stringMatching.kmp;

import java.util.*;

public class RotatingPermutation_12104 {
    static int kmp(String s, String p){
        int ans = 0;
        int[] pi = preprocessing(p);
        int n = s.length();
        int m = p.length();
        int j = 0;
        for(int i=0; i<n; i++){
            while (j>0 && s.charAt(i) != p.charAt(j)){
                j = pi[j-1];
            }
            if(j == m-1){
                ans += 1;
                j = pi[j];
            }else{
                j += 1;
            }
        }

        return ans;
    }
    static int[] preprocessing(String p){
        int m = p.length();
        int[] pi = new int[m];
        pi[0] = 0;
        int j = 0;
        for(int i=1; i<m; i++){
            while (j > 0 && p.charAt(i) != p.charAt(j)){
                j = pi[j-1];
            }

            if(p.charAt(i) == p.charAt(j)){
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
        String a = sc.next();
        String b = sc.next();
        b += b;
        int n = b.length();
        b = b.substring(0, n-1);

        System.out.println(kmp(b, a));

    }
}

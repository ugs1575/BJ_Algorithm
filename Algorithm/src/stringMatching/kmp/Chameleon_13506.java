package stringMatching.kmp;

import java.util.*;

public class Chameleon_13506 {
    static int[] preprocessing(String p){
        int m = p.length();
        int[] pi = new int[m];
        pi[0] = 0;
        int j = 0;
        for(int i=1; i<m; i++){
            while (j>0 && p.charAt(i) != p.charAt(j)){
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
        String t = sc.next();
        int n = t.length();
        int[] pi = preprocessing(t);
        for(int i:pi){
            System.out.println(i);
        }

        int[] cnt = new int[n+1];
        for(int i=0; i<n-1; i++){
            cnt[pi[i]] += 1;
        }
        for(int i=n; i!=0; i=pi[i-1]){
            if(cnt[i] >= 1){
                System.out.println(t.substring(0,i));
                System.exit(0);
            }
        }
        System.out.println(-1);
    }
}

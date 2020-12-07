/*
* fail[i] = P의 i까지 부분 문자열에서
* prefix == suffix가 될 수 있는 부분 문자열 중에서
* 가장 긴 것의 길이를 저장하기 때문에
* 문제에서 가장 짧은 것을 구하라 하였으니
* 길이에서 pi값을 빼주면 된다..
* */
package stringMatching.kmp;

import java.util.Scanner;

public class Advertisement_1305 {
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
        int n = sc.nextInt();
        String p = sc.next();

        int[] pi = preprocessing(p);
        System.out.println(n-pi[n-1]);
    }
}

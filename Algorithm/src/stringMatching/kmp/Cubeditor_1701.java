package stringMatching.kmp;

import java.io.*;

public class Cubeditor_1701 {
    static int[] preprocessing(String t){
        int m = t.length();
        int[] pi = new int[m];
        pi[0] = 0;
        int j = 0;
        for(int i=1; i<m; i++){
            while (j>0 && t.charAt(i) != t.charAt(j)){
                j = pi[j-1];
            }
            if(t.charAt(i) == t.charAt(j)){
                pi[i] = j+1;
                j += 1;
            }else{
                pi[i] = 0;
            }
        }

        return pi;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        String temp = t;
        int n = t.length();
        int max = 0;
        for(int i=0; i<n; i++){
            temp = t.substring(i,n);
            int[] pi = preprocessing(temp);
            for(int j:pi){
                if(j > max){
                    max = j;
                }
            }
        }


        System.out.println(max);
    }
}

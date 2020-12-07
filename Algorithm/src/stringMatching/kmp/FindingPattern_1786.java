package stringMatching.kmp;

import java.io.*;
import java.util.ArrayList;

public class FindingPattern_1786 {
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
    static ArrayList<Integer> kmp(String t, String p){
        int[] pi = preprocessing(p);
        int n = t.length();
        int m = p.length();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int j = 0;
        for(int i=0; i<n; i++){
            while (j>0 && t.charAt(i) != p.charAt(j)){
                j = pi[j-1];
            }
            if(t.charAt(i) == p.charAt(j)){
                if(j == m-1){
                    list.add(i-m+2);
                    j = pi[j];
                }else{
                    j += 1;
                }

            }
        }

        return list;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        String p = br.readLine();
        ArrayList<Integer> ans = kmp(t,p);
        System.out.println(ans.size());
        for(int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
}

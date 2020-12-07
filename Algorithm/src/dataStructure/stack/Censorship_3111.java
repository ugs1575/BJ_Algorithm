package dataStructure.stack;

import java.util.*;

public class Censorship_3111 {
    static int lIdx = 0;
    static int rIdx = 0;
    static boolean check(String a, int where, Character[] st){
        if(where == 1){
            int temp = rIdx;
            for(int i=0; i<a.length(); i++){
                if(st[--temp] != a.charAt(i)) return false;
            }
        }else{
            int temp = lIdx;
            for(int i=a.length()-1; i>=0; i--){
                if(st[--temp] != a.charAt(i)) return false;
            }
        }


        if(where == 1){
            for(int i=0; i<a.length(); i++){
                st[--rIdx] = ' ';
            }
        }else{
            for(int i=0; i<a.length(); i++){
                st[--lIdx] = ' ';
            }
        }



        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String t = sc.next();
        int n = t.length();
        int where = 0; //0:왼쪽 부터 검사, 1:오른쪽 부터 검사
        int left = 0;
        int right = t.length()-1;

        Character[] l = new Character[n];
        Character[] r = new Character[n];

        while(left <= right){
            if(where == 0){
                l[lIdx++] = t.charAt(left++);
            }else{
                r[rIdx++] = t.charAt(right--);
            }
            boolean res = false;
            if(where == 0 && lIdx >= a.length()){
                res = check(a, where, l);
            }else if(where == 1 && rIdx >= a.length()){
                res = check(a, where, r);
            }
            if(res) {
                where = 1-where;
            }
        }


        for(int i=rIdx-1; i>=0; i--){
            l[lIdx++] = r[i];
            if(lIdx >= a.length()){
                check(a, 0, l);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<lIdx; i++){
            sb.append(l[i]);
        }

        System.out.println(sb.toString());






    }
}

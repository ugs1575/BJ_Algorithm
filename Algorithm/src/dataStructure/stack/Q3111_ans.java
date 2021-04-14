package dataStructure.stack;

import java.util.Scanner;

public class Q3111_ans {
    static char[] l = new char[300001];
    static char[] r = new char[300001];
    static int ln = 0, rn = 0;
    static char[] a, ar, b;
    static int n, m;
    static boolean check(int where){
        char[] stack = l;
        int len = ln;
        char[] str = ar;
        if(where == 1){
            stack = r;
            len = rn;
            str = a;
        }
        if(len-n < 0){
            return false;
        }
        for(int i=0; i<n; i++){
            if(stack[len-i-1] != str[i]){
                return  false;
            }
        }
        if(where == 0){
            ln -= n;
        }else{
            rn -= n;
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextLine().toCharArray(); //검열할 단어
        n = a.length;
        ar = new char[n]; //검열할 단어 거꾸로해서 저장
        for(int i=0; i<n; i++){
            ar[i] = a[n-1-1];
        }
        b = sc.nextLine().toCharArray(); //텍스트
        m = b.length;
        int left = 0;
        int right = m-1;
        int where = 0;
        while (left <= right){
            if(where == 0){
                l[ln++] = b[left++];
            }else{
                r[rn++] = b[right--];
            }
            if(check(where)){
                where = 1-where;
            }
        }

        for(int i=rn-1; i>=0; i--){
            l[ln++] = r[i];
            check(0);
        }

        for(int i=0; i<ln; i++){
            System.out.print(l[i]);
        }
        System.out.println();
    }
}

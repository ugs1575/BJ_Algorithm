package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Recursion_1759 {
    static int c;
    static boolean[] isVisit, check;
    static char[] aAlpha;
    static char[] aVowel = {'a', 'e', 'o', 'u', 'i'};
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        c = sc.nextInt();
        isVisit = new boolean[c];
        check   = new boolean[c];
        sc.nextLine();
        String input = sc.nextLine();
        input = input.replaceAll("\\s","");

        aAlpha = input.toCharArray();
        Arrays.sort(aAlpha);

        for(int i=0; i<input.length(); i++){
            for(int j=0; j<5; j++){
                if(aAlpha[i] == aVowel[j]){
                    check[i] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        go(0, sb, l, 0);

    }

    public static boolean isCorrect(String str){
        boolean res = false;
        int x = 0;
        int y = 0;
        char[] aPassword = str.toCharArray();
        for(int j=0; j<str.length(); j++){
            for(int i=0; i<c; i++){
                if(aPassword[j] == aAlpha[i]){
                    if(check[i]){
                        x++;
                    }else{
                        y++;
                    }
                }
            }
        }

        if(x >= 1 && y >= 2){
            res = true;
        }

        return res;
    }

    public static void go(int start, StringBuilder sb, int goal, int cnt){
        if(cnt == goal){
            String password = sb.toString();
            boolean result = isCorrect(password);
            if(result) System.out.println(password);
        }

        for(int i=start; i<c; i++){
            if(isVisit[i]){
                continue;
            }

            isVisit[i] = true;
            sb.append(aAlpha[i]);
            go(i+1, sb, goal, cnt+1);
            String ans = sb.substring(0, cnt);
            sb = new StringBuilder();
            sb.append(ans);
            isVisit[i] = false;

        }

        return ;
    }
}
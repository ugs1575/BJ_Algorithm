package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class MakingPassword_1759 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        boolean[] check = new boolean[c];
        char[] ans = new char[l];

        //remove all whitespaces
        str = str.replaceAll("\\s","");

        char[] alpa = str.toCharArray();
        Arrays.sort(alpa);

        combination(l, c, 0, 0, check, alpa, ans);

    }

    public static void combination(int l, int c, int start, int index, boolean[] check, char[] alpa, char[] ans){
        if(index == l){
            StringBuilder sb = new StringBuilder();
            int consonant = 0;
            int vowel = 0;
            for(int i=0; i<l; i++){
                sb.append(ans[i]);
                if(ans[i] == 'a' || ans[i] == 'e' || ans[i] == 'i' || ans[i] == 'o' || ans[i] == 'u'){
                    consonant++;
                }else{
                    vowel++;
                }
            }

            if(consonant >= 1 && vowel >= 2){
                System.out.println(sb);
            }
        }else{
            for(int i=start; i<c; i++){
                if(check[i]) continue;
                ans[index] = alpa[i];
                check[i] = true;
                combination(l, c, i+1,index+1, check, alpa, ans);
                check[i] = false;
            }
        }
    }
}

package bruteforce.permutation;

import java.util.Scanner;

public class WordMath_1339 {
    static int[] alpha, aAns;
    static String[] word;
    static boolean[] isVisited, isIncluded;
    static int n, ans, cnt;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        n          = sc.nextInt();
        ans        = 0;
        isIncluded = new boolean[26]; //단어 포함 여부
        isVisited  = new boolean[10]; //방문여부
        alpha      = new int[26]; //단어 포함 여부
        word       = new String[n];

        for(int i=0; i<n; i++){
            word[i] = sc.next();
        }


        for(int i=0; i<n; i++){
            String input = word[i];
            for(int j=0; j<input.length(); j++){
                int idx = (int) input.charAt(j) - 65;
                isIncluded[idx] = true;
            }
        }

        cnt = 0;
        for(int i=0; i<26; i++){
            if(isIncluded[i]) cnt++;
        }

        aAns      = new int[cnt];

        permutation(0);

        System.out.println(ans);

    }

    public static void permutation(int index){
        if(index == cnt){
            int idx = 0;
            for(int i=0; i<26; i++){
                if(isIncluded[i]){
                    alpha[i] = aAns[idx];
                    idx++;
                }
            }

            int sum = 0;
            for(int i=0; i<n; i++){
                String input = word[i];
                int res = 0;
                for(int j=0; j<input.length(); j++){
                    int alphabet = (int) input.charAt(j) - 65;
                    res = res * 10 + alpha[alphabet];
                }

                sum += res;
            }

            ans = Math.max(sum, ans);
        }else{
            for(int i=0; i<10; i++){
                if(isVisited[i]) continue;
                isVisited[i]  = true;
                aAns[index]   = i;
                permutation(index+1);
                isVisited[i]  = false;
            }
        }
    }
}

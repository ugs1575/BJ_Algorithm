package bruteforce.permutation;

import java.util.Scanner;

public class InequalitySign_2529 {
    static int n;
    static boolean[] check;
    static char[] aStr;
    static Long min = Long.MAX_VALUE;
    static Long max = Long.MIN_VALUE;
    static String sMin, sMax;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        str = str.replaceAll("\\s","");
        aStr = str.toCharArray();

        int[] ans = new int[n+1];
        check = new boolean[10];

        permutation(0, ans);

        System.out.println(sMax);
        System.out.println(sMin);


    }

    public static void permutation(int index, int[] ans){
        if(index == n+1){
            boolean isAns = true;
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<n; i++){
                sb.append(ans[i]);
                if(aStr[i] == '<'){
                    if(ans[i] > ans[i+1]) {
                        isAns = false;
                        break;
                    }
                }else{
                    if(ans[i] < ans[i+1]) {
                        isAns = false;
                        break;
                    }
                }
            }

            if(isAns){
                sb.append(ans[n]);
                long num = Long.parseLong(sb.toString());
                if(num < min){
                    min = num;
                    sMin = sb.toString();
                }

                if(num > max){
                    max = num;
                    sMax = sb.toString();
                }
            }
        }else{
            for(int i=0; i<10; i++){
                if(check[i]) continue;
                ans[index] = i;
                check[i] = true;
                permutation(index+1, ans);
                check[i] = false;
            }
        }
    }
}

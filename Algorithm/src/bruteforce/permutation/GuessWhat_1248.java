package bruteforce.permutation;

import java.util.Scanner;

public class GuessWhat_1248 {
    static int n;
    static char[][] arr;
    static int[] ans;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new char[n][n];
        ans = new int[n*(n+1)/2];
        sc.nextLine();
        String str = sc.next();
        int idx = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                arr[i][j] = str.charAt(idx++);
            }
        }

        permutation(0);

        for(int i=0; i<n; i++){
            System.out.print(ans[i]+" ");
        }

    }

    public static boolean isCorrect(int index){
        int sum = 0;
        for(int i=index; i>=0; i--){
            sum += ans[i];
            if(sum == 0 && arr[i][index] != '0'){
                return false;
            }else if(sum > 0 && arr[i][index] != '+'){
                return false;
            }else if(sum < 0 && arr[i][index] != '-'){
                return false;
            }

        }

        return true;
    }

    public static boolean permutation(int index){
        if(index == n){
            return true;
        }
        for(int i=-10; i<=10; i++){
            ans[index] = i;
            if(isCorrect(index) && permutation(index+1)) return true;
        }

        return false;
    }
}

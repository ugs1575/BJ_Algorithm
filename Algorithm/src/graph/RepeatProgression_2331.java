import java.util.ArrayList;
import java.util.Scanner;

public class RepeatProgression_2331 {
    static int p;
    static ArrayList<Integer> check;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        p = sc.nextInt();

        //check[0]값으로 a를 넣어준다
        check = new ArrayList<Integer>();
        check.add(Integer.parseInt(a));

        int ans = dfs(a, 1);

        System.out.println(ans);
    }

    public static int dfs(String num, int idx){
        char[] aChar = num.toCharArray();
        int sum = 0;
        for(int i=0; i<aChar.length; i++){
            int n = Character.getNumericValue(aChar[i]);
            int squareNum = (int) Math.pow(n,p);
            sum += squareNum;
        }
        check.add(sum);

        for(int i=0; i<idx; i++){
            if(check.get(i) == sum){
                return i;
            }
        }
        String next = Integer.toString(sum);
        idx++;
        return dfs(next,idx);

    }
}

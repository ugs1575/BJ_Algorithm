package DynamicProgramming;
import java.util.*;
/**
 * Created by woogyeongseo on 29/9/19.
 */
public class CrypticCode {
    public static int mod = 1000000;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int l = n.length();
        n = " "+n;
        int[] d = new int[l+1];

        d[0] = 1;

        for(int i=1; i<=l; i++){
            int x = Character.getNumericValue(n.charAt(i));
            if(x!=0 && x>=1 && x<=9){
                d[i]+=d[i-1];
                d[i]%=mod;
            }

            if(Character.getNumericValue(n.charAt(i-1))!=0){
                x = Character.getNumericValue(n.charAt(i-1))*10+Character.getNumericValue(n.charAt(i));
                if(x>=10 && x<=26){
                    d[i]+=d[i-2];
                    d[i]%=mod;
                }
            }
        }



        System.out.print(d[l]);
    }
}

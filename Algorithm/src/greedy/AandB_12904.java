package greedy;

import java.util.Scanner;

public class AandB_12904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        StringBuilder sb = new StringBuilder();

        while (t.length() > s.length()){
            boolean reverse = false;
            if(t.charAt(t.length() - 1) == 'B'){
                reverse = true;
            }
            t = t.substring(0,t.length()-1);
            if(reverse){
                sb.append(t);
                t = sb.reverse().toString();
                sb = new StringBuilder();
            }
        }

        if(t.equals(s)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}

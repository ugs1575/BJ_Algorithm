package dataStructure.stack;

import java.util.*;
public class Q9012 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<n; i++){
            System.out.println(isValid(sc.nextLine()));

        }
    }

    public static String isValid(String input){
        int cnt = 0;
        for(int x=0; x<input.length(); x++){
            if(input.charAt(x)=='('){
                cnt ++;
            }else{
                cnt --;
            }
            if(cnt<0){
                return "NO";
            }
        }


        if(cnt==0){
            return "YES";
        }else{
            return "NO";
        }
    }
}
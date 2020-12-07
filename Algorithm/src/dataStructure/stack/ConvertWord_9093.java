package dataStructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class ConvertWord_9093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        sc.nextLine();
        for(int t=0; t<tc; t++){
            StringBuilder sb = new StringBuilder();
            String s = sc.nextLine();
            String[] a = s.split(" ");
            Stack<Character> st = new Stack<>();
            int index = 0;
            for(int i=0; i<a.length; i++){
                for(int j=0; j<a[i].length(); j++){
                    index += 1;
                    st.push(a[i].charAt(j));
                }

                while (!st.empty()){
                    sb.append(st.pop());
                }

                if(index <s.length() && s.charAt(index) == ' '){
                    index += 1;
                    sb.append(' ');
                }
            }


            System.out.println(sb);
        }
    }
}

package dataStructure.stack;

import java.util.*;

public class CovertWord_17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        boolean[] aWord = new boolean[s.length()];
        boolean isWord = true;
        //단어 인지 아닌지 검사
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '<'){
                isWord = false;
            }
            aWord[i] = isWord;
            if(s.charAt(i) == '>'){
                isWord = true;
            }
        }


        for(boolean b:aWord){
            if(b){
                System.out.print(1);
            }else{
                System.out.print(2);
            }
        }

        System.out.println();

        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(!aWord[i]){
                if(s.charAt(i) == '<'){
                    while (!st.isEmpty()){
                        ans.append(st.pop());
                    }
                }
                ans.append(s.charAt(i));
            }else{
                if(s.charAt(i) == ' '){
                    while (!st.isEmpty()){
                        ans.append(st.pop());
                    }
                    ans.append(' ');
                }else{
                    st.push(s.charAt(i));
                    if(i == s.length()-1){
                        while (!st.isEmpty()){
                            ans.append(st.pop());
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}

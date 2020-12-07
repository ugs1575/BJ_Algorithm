package dataStructure.stack;

import java.util.*;

class Pair20{
    int first, second;
    Pair20(int first, int second){
        this.first = first;
        this.second = second;
    }
}

public class StringExplosion_9935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int n = s.length();
        int m = t.length();
        boolean[] erased = new boolean[n];

        if(m == 1){
            for(int i=0; i<n; i++){
                if (s.charAt(i) == t.charAt(0)) {
                    erased[i] = true;
                }
            }
        }else{
            Stack<Pair20> st = new Stack<Pair20>();
            for(int i=0; i<n; i++){
                //지워야할 첫 글자와 동일하면 넣기
                if(s.charAt(i) == t.charAt(0)){
                    st.add(new Pair20(i, 0));
                }else{
                    if(!st.empty()){
                        //top의 지워야할 문자열 인덱스의 다음 인덱스와 같다면 지워야할 문자열의 연속이다.
                        int top = st.peek().second;
                        if(s.charAt(i) == t.charAt(top+1)){
                            st.add(new Pair20(i, top+1));
                            //지워야할 문자열의 마지막인덱스가 들어왔다면 스택에서 pop함과 동시에 지워준다.
                            if(top+1 == m-1){
                                for(int j=0; j<m; j++){
                                    Pair20 p = st.pop();
                                    erased[p.first] = true;
                                }
                            }
                        }else{
                            //다음 인덱스가 지워야할 문자열의 다음 인덱스가 아니면
                            //그 전에 쌓아둔 문자도 지워야할 문자열이 될 수가 없기때문에 모두 pop 해준다.
                            while (!st.empty()){
                                st.pop();
                            }
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        boolean empty = true;
        for(int i=0; i<n; i++){
            if(!erased[i]){
                empty = false;
                sb.append(s.charAt(i));
            }
        }

        if(empty){
            System.out.println("FRULA");
        }else{
            System.out.println(sb);
        }

    }
}

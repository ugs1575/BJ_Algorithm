package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class NNotation {
    static HashMap<Integer, String> map;
    public void change(int n, int num, ArrayList<String> list){
        Stack<String> st = new Stack<>();
        while (num >= n){
            int left = num%n;
            if(left >= 10) {
                st.add(map.get(left));
            }else{
                st.add(String.valueOf(left));
            }
            num /= n;
        }

        if(num >= 10){
            st.add(map.get(num));
        }else{
            st.add(String.valueOf(num));
        }

        while (!st.isEmpty()){
            list.add(st.pop());
        }


    }
    public String solution(int n, int t, int m, int p) {
        ArrayList<String> list = new ArrayList<>();
        map = new HashMap<>();
        map.put(10,"A");
        map.put(11,"B");
        map.put(12,"C");
        map.put(13,"D");
        map.put(14,"E");
        map.put(15,"F");
        int num = 0;
        list.add(String.valueOf(num));
        while (true){
            num += 1;
            change(n, num, list);
            if(list.size() >= m*t) break;
        }

        String answer = "";
        for(int i=0; i<list.size(); i++){
            if((i%m) == (p-1)){
                answer += list.get(i);
                if(answer.length() == t) break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        NNotation n = new NNotation();
        System.out.println(n.solution(2,4,2,1));
    }
}

package programmers;

import java.util.*;

public class Compressing {
    public int[] solution(String msg) {
        //사전 초기화
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=65; i<=90; i++){
            char alpha = (char) i;
            String str = "";
            str += alpha;
            map.put(str, i-'A'+1);
        }

        //가장 긴 문자열 찾기
        int maxIndex = 27;
        ArrayList<Integer> list = new ArrayList<>();
        int n = msg.length();
        for(int i=0; i<n; i++){
            int index = 0;
            for(int j=i+1; j<=n; j++){
                String w = msg.substring(i, j);
                if(!map.containsKey(w)){
                    i = j-2;
                    map.put(w, maxIndex++);
                    break;
                }else{
                    index = map.get(w);
                    if (j == n) i = n;
                }
            }
            list.add(index);
        }

        //배열로 변경
        int[] answer = new int[list.size()];
        for(int i=0; i< list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Compressing c = new Compressing();
        String msg = "ABABABABABABABAB";
        c.solution(msg);
    }
}

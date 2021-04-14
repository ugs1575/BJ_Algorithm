package programmers;

import java.util.HashMap;

public class Runner {
    static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(String name : participant){
            if(hm.containsKey(name)){
                int cnt = hm.get(name);
                cnt += 1;
                hm.put(name, cnt);
            }else{
                hm.put(name, 1);
            }
        }

        for(String name : completion){
            int cnt = hm.get(name);
            cnt -= 1;
            hm.put(name, cnt);
        }

        String answer = "";
        for(String name : hm.keySet()){
            if(hm.get(name) == 1) {
                answer = name;
                break;
            }
        }


        return answer;
    }
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"mislav", "stanko", "ana"};
        solution(participant, completion);

    }
}

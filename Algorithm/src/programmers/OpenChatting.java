package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenChatting {
    public String[] solution(String[] record) {
        HashMap<String, String> nameMap = new HashMap<>();

        //마지막 닉네임 저장
        for(String rcd : record){
            String[] splitRecord = rcd.split(" ");
            String state = splitRecord[0];
            String userId = splitRecord[1];

            if(state.equals("Enter") || state.equals("Change")){
                String nickName = splitRecord[2];
                nameMap.put(userId, nickName);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for(String rcd : record){
            String[] splitRecord = rcd.split(" ");
            String state = splitRecord[0];
            String userId = splitRecord[1];

            String nickName = nameMap.get(userId);
            if(state.equals("Enter")){
                list.add(nickName+"님이 들어왔습니다.");
            }else if(state.equals("Leave")) {
                list.add(nickName+"님이 나갔습니다.");
            }
        }

        String[] answer = new String[list.size()];
        int idx = 0;
        for (String s : list) {
            answer[idx++] = s;
        }

        return answer;
    }

    public static void main(String[] args) {
        OpenChatting o = new OpenChatting();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        o.solution(record);
    }
}

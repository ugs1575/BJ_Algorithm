package programmers;

import java.util.ArrayList;
import java.util.HashSet;

public class CandidateKey {
    static ArrayList<Integer> uniqueKeys;
    static int attrCnt;
    static int tupleCnt;
    public int solution(String[][] relation) {
        uniqueKeys = new ArrayList<>();
        attrCnt = relation[0].length;
        tupleCnt = relation.length;

        for(int i=1; i<(1<<attrCnt); i++){
            if(!isMinimal(i)) continue;
            if(!isUnique(i, relation)) continue;
            uniqueKeys.add(i);
        }
        return uniqueKeys.size();
    }

    public boolean isUnique(int set, String[][] relation) {
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<tupleCnt; i++){
            String str = "";
            for(int j=0; j<attrCnt; j++){
                if((set & (1<<j)) != 0){
                    str += relation[i][j];
                }
            }
            if(hs.contains(str)){
                return false;
            } else {
                hs.add(str);
            }
        }

        return true;
    }

    public boolean isMinimal(int set) {
        for(int i : uniqueKeys){
            if((i & set) == i) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},
                {"200","apeach","math","2"},{"300","tube","computer","3"},
                {"400","con","computer","4"},{"500","muzi","music","3"},
                {"600","apeach","music","2"}};
        CandidateKey c = new CandidateKey();
        System.out.println(c.solution(relation));
    }
}

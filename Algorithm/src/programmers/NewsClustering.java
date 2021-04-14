package programmers;

import java.util.*;

public class NewsClustering {
    static int aCnt;
    static int bCnt;
    static HashMap<String, Integer> setA;
    static HashMap<String, Integer> setB;
    public void makeSet(String str, int type){
        for(int i=0; i<str.length()-1; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(i));
            sb.append(str.charAt(i+1));
            String set = sb.toString().toUpperCase(Locale.ROOT);
            int a = set.charAt(0);
            int b = set.charAt(1);
            if(a >= 65 && a <= 90 && b >= 65 && b <= 90){
                if(type == 0){
                    aCnt += 1;
                    if(setA.containsKey(set)){
                        int v = setA.get(set);
                        setA.put(set, v+1);
                    }else{
                        setA.put(set, 1);
                    }
                }else if(type == 1){
                    bCnt += 1;
                    if(setB.containsKey(set)){
                        int v = setB.get(set);
                        setB.put(set, v+1);
                    }else{
                        setB.put(set, 1);
                    }
                }
            }
        }
    }
    public int solution(String str1, String str2) {
        aCnt = 0;
        bCnt = 0;
        setA = new HashMap();
        setB = new HashMap();

        makeSet(str1, 0);
        makeSet(str2, 1);

        int same = 0;
        Iterator<Map.Entry<String, Integer>> itr = setA.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry<String, Integer> entry = itr.next();
            String aKey = entry.getKey();
            if(setB.containsKey(aKey)){
                int va = setA.get(aKey);
                int vb = setB.get(aKey);
                same += Math.min(va, vb);
            }
        }

        int total = aCnt+bCnt-same;
        int answer = 65536;
        if(total != 0) {
            answer = same*65536/(aCnt+bCnt-same);
        }
        return answer;
    }
    public static void main(String[] args) {
        NewsClustering n = new NewsClustering();
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        System.out.println(n.solution(str1, str2));
    }
}

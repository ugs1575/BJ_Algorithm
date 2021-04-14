package programmers;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUCache {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0){
            return cities.length * 5;
        }

        Deque<String> dq = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();

        int answer = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            if(!hs.contains(city)){
                answer += 5;
                if(dq.size() == cacheSize && cacheSize != 0){
                    hs.remove(dq.removeLast());
                }
            }else{
                answer += 1;
                dq.remove(city);
            }
            dq.push(city);
            hs.add(city);
        }
        return answer;
    }

    public static void main(String[] args) {
        int cacheSize = 8;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        LRUCache l = new LRUCache();
        l.solution(cacheSize, cities);
    }
}

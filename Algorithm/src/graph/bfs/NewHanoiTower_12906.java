/*
* 같은 상태가 나오면 안된다.
* HashMap<List<String>, Integer> d = new HashMap<>();
* Queue<List<String>> q = new LinkedList<>();
*
* hashmap key를 list로 두어서 중복검사를 할수 있다.
*
*
* */


package graph.bfs;

import java.util.*;

public class NewHanoiTower_12906 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = new String[3];
        for(int i=0; i<3; i++){
            int cnt = sc.nextInt();
            if(cnt > 0){
                s[i] = sc.next();
            }else{
                s[i] = "";
            }
        }

        int[] cnt = new int[3];
        for(int i=0; i<3; i++){
            for(char c : s[i].toCharArray()){
                cnt[c-'A'] += 1;
            }
        }

        HashMap<List<String>, Integer> hm = new HashMap<>();
        Queue<List<String>> q = new LinkedList<>();
        hm.put(Arrays.asList(s), 0);
        q.add(Arrays.asList(s));
        while (!q.isEmpty()){
            String[] now = q.remove().toArray(new String[3]);
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i == j) continue;
                    if(now[i].length() == 0) continue;
                    String[] next = {now[0], now[1], now[2]};
                    next[j] = now[j] + now[i].charAt(now[i].length() - 1);
                    next[i] = now[i].substring(0, now[i].length() - 1);
                    if(!hm.containsKey(Arrays.asList(next))){
                        hm.put(Arrays.asList(next), hm.get(Arrays.asList(now))+1);
                        q.add(Arrays.asList(next));
                    }
                }
            }
        }

        String[] ans = new String[3];
        for(int i=0; i<3; i++){
            ans[i] = "";
            for(int j=0; j<cnt[i]; j++){
                ans[i] += (char) (i+'A');
            }
        }

        System.out.println(hm.get(Arrays.asList(ans)));

    }
}

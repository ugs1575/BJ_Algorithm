package divideConquer.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NumberCard2_10816 {
    public static boolean search(int x, ArrayList<Integer> num, HashMap<Integer, Integer> map){
        int left = 0;
        int right = num.size()-1;
        while (left <= right){
            int mid = (left+right)/2;
            if(num.get(mid) == x){
                return true;
            }else if(x < num.get(mid)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        String[] a = br.readLine().split(" ");
        ArrayList<Integer> num = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int key = Integer.valueOf(a[i]);
            int cnt = 1;
            if(map.containsKey(key)){
                cnt = map.get(key);
                cnt += 1;
            }else{
                num.add(key);
            }
            map.put(key, cnt);
        }

        Collections.sort(num);

        StringBuilder sb = new StringBuilder();
        int m = Integer.valueOf(br.readLine());
        String[] a2 = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            int key = Integer.valueOf(a2[i]);
            boolean find = search(key, num, map);
            if(find) sb.append(map.get(key)+" ");
            else sb.append("0 ");
        }

        System.out.println(sb);
    }
}

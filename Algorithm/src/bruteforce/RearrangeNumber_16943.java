package bruteforce;

import java.util.*;

public class RearrangeNumber_16943 {
    static int a, b;
    static void permutation(ArrayList<Integer> list, int[] ans, int[] arr, boolean[] check, int index){
        if(index == ans.length){
            if(ans[0] != 0){
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<ans.length; i++){
                    sb.append(ans[i]);
                }
                int temp = Integer.parseInt(sb.toString());
                if(temp != a && temp <= b) list.add(temp);
            }
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(check[i]) continue;
            check[i] = true;
            ans[index] = arr[i];
            permutation(list, ans, arr, check, index+1);
            check[i] = false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        String s = String.valueOf(a);
        int[] arr = new int[s.length()];
        int[] ans = new int[s.length()];
        boolean[] check = new boolean[s.length()];
        for(int i=0; i<s.length(); i++){
            arr[i] = s.charAt(i)-'0';
        }

        ArrayList<Integer> list = new ArrayList<>();
        permutation(list, ans, arr, check, 0);
        if(list.isEmpty()){
            System.out.println(-1);
        }else{
            Collections.sort(list);
            System.out.println(list.get(list.size()-1));
        }
    }
}

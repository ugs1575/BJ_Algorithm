package dataStructure.bst;

import java.util.*;

public class NameList_1764{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<String> ts = new TreeSet<String>();
        ArrayList<String> ans = new ArrayList<String>();
        for(int i=0; i<n+m; i++){
            String name = sc.next();
            if(ts.contains(name)){
                ans.add(name);
            }else{
                ts.add(name);
            }

        }
        System.out.println(ans.size());
        Collections.sort(ans);
        for(String name:ans){
            System.out.println(name);
        }

    }

}

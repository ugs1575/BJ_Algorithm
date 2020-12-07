package dataStructure.bst;

import java.util.*;

class Compare implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}

public class WorkersInTheOffice_7785 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Compare cmp = new Compare();
        TreeMap<String, String> tm = new TreeMap<String, String>(cmp);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            String name = sc.next();
            String log = sc.next();
            if(!tm.containsKey(name)){
                if(log.equals("enter")){
                    tm.put(name, log);
                }
            }else{
                if(tm.get(name).equals("enter") && log.equals("leave")){
                    tm.remove(name);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> e : tm.entrySet()){
            sb.append(e.getKey()+"\n");
        }
        System.out.println(sb.toString());
    }
}

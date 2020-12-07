package stringMatching.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Node2 {
    boolean valid;
    int[] children;
    Node2(){
        valid = false;
        children = new int[26];
        for(int i=0; i<26; i++){
            children[i] = -1;
        }
    }
}

class Phone implements Comparable<Phone> {
    String s;
    int l;
    Phone(String s, int l){
        this.s = s;
        this.l = l;
    }

    @Override
    public int compareTo(Phone that) {
        if(this.l < that.l){
            return -1;
        }else if(this.l == that.l){
            return 0;
        }else{
            return 1;
        }
    }
}

public class NumberList_5052 {
    static ArrayList<Node2> trie;
    static int init(){
        Node2 x = new Node2();
        trie.add(x);
        return trie.size()-1;
    }
    static void add(int node, String s, int index){
        if(index == s.length()){
            trie.get(node).valid = true;
            return;
        }
        int c = s.charAt(index) - '0';
        if(trie.get(node).children[c] == -1){
            int next = init();
            trie.get(node).children[c] = next;
        }

        add(trie.get(node).children[c], s, index+1);
    }
    static boolean search(int node, String s, int index){
        if(index == s.length()) return true;
        if(trie.get(node).valid) return false;
        int c = s.charAt(index) - '0';
        int next = trie.get(node).children[c];
        return search(next, s, index+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            trie = new ArrayList<>();
            int root = init();
            int n = sc.nextInt();
            Phone[] list = new Phone[n];
            for(int i=0; i<n; i++){
                String str = sc.next();
                list[i] = new Phone(str, str.length());
                add(root, list[i].s, 0);
            }

            Arrays.sort(list);

            boolean ok = true;
            for(int i=n-1; i>=0; i--){
                if(!search(root, list[i].s, 0)){
                    ok = false;
                }
            }

            System.out.println(ok? "YES":"NO");
        }


    }


}

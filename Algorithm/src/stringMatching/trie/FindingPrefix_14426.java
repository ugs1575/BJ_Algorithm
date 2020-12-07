package stringMatching.trie;

import java.io.*;
import java.util.*;

class Trie2{
    class Node{
        int[] children;
        boolean valid;
        Node(){
            children = new int[26];
            for(int i=0; i<26; i++){
                children[i] = -1;
            }
            valid = false;
        }
    }
    int root;
    ArrayList<Node> trie;
    int init(){
        Node x = new Node();
        trie.add(x);
        return trie.size()-1;
    }
    Trie2(){
        trie = new ArrayList<Node>();
        root = init();
    }
    void add(int node, String s, int index){
        if(index == s.length()){
            trie.get(node).valid = true;
            return;
        }
        int c = s.charAt(index) - 'a';
        if(trie.get(node).children[c] == -1){
            int next = init();
            trie.get(node).children[c] = next;
        }
        int child = trie.get(node).children[c];
        add(child, s, index+1);
    }
    void add(String s){
        add(root, s, 0);
    }
    boolean search(int node, String s, int index){
        if(node == -1) return false;
        if(index == s.length()) return true;
        int c = s.charAt(index) - 'a';
        int child = trie.get(node).children[c];
        return search(child, s, index+1);
    }
    boolean search(String s){
        return search(root, s, 0);
    }
}

public class FindingPrefix_14426 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        int n = Integer.parseInt(a[0]);
        int m = Integer.parseInt(a[1]);
        Trie2 trie = new Trie2();
        for(int i=0; i<n; i++){
            trie.add(br.readLine());
        }
        int ans = 0;
        for(int i=0; i<m; i++){
            if(trie.search(br.readLine())){
                ans += 1;
            }
        }
        System.out.println(ans);
    }

}

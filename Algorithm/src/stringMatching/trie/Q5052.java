package stringMatching.trie;

import java.util.*;

class Trie5 {
    int root;
    ArrayList<Node> trie;
    class Node {
        boolean valid;
        int[] children;
        Node(){
            valid = false;
            children = new int[10];
            for(int i=0; i<10; i++){
                children[i] = -1;
            }
        }
    }
    int init(){
        Node x = new Node();
        trie.add(x);
        return trie.size()-1;
    }
    Trie5(){
        trie = new ArrayList<>();
        root = init();
    }
    void add(int node, String num, int index){
        if(index == num.length()){
            trie.get(node).valid = true;
            return;
        }
        int c = num.charAt(index)-'0';
        if(trie.get(node).children[c] == -1){
            int next = init();
            trie.get(node).children[c] = next;
        }

        add(trie.get(node).children[c], num, index+1);
    }
    void add(String number){
        add(root, number, 0);
    }
    boolean search(int node, String number, int index){
        if(trie.get(node).valid){
            for(int i=0; i<10; i++){
                if(trie.get(node).children[i] != -1){
                    return true;
                }
            }

            return false;
        }

        int c = number.charAt(index)-'0';
        return search(trie.get(node).children[c], number, index+1);
    }
    boolean search(String number){
        return search(root, number, 0);
    }

}

public class Q5052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            Trie5 trie = new Trie5();
            int n = sc.nextInt();
            String[] a = new String[n];
            for(int i=0; i<n; i++){
                a[i] = sc.next();
                trie.add(a[i]);
            }

            boolean ok = true;
            for(int i=0; i<n; i++){
                if(trie.search(a[i])){
                    ok = false;
                }
            }

            System.out.println(ok? "YES":"NO");
        }
    }
}

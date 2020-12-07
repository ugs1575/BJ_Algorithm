package stringMatching.trie;

import java.util.*;


class Trie4 {
    int root;
    ArrayList<Node> trie;
    class Node {
        boolean valid;
        int[] children;
        Node() {
            valid = false;
            children = new int[2];
            for(int i=0; i<2; i++){
                children[i] = -1;
            }
        }
    }
    int init(){
        Node x = new Node();
        trie.add(x);
        return trie.size()-1;
    }
    Trie4() {
        trie = new ArrayList<>();
        root = init();
    }
    void add(int node, int num, int bit){
        if(bit == -1){
            trie.get(node).valid = true;
            return;
        }
        int c = (num >> bit) & 1;
        if(trie.get(node).children[c] == -1){
            int next = init();
            trie.get(node).children[c] = next;
        }
        add(trie.get(node).children[c], num, bit-1);
    }
    void add(int num){
        add(root, num, 31);
    }
    int search(int node, int num, int bit){
        int c = (num >> bit) & 1;
        c = 1-c;

        if(trie.get(node).children[c] == -1){
            c = 1-c;
        }

        if(trie.get(node).children[c] == -1){
            return 0;
        }

        int next = 0;
        if(c == 1) next = (1 << bit);
        return next | search(trie.get(node).children[c], num, bit-1);
    }
    int search(int num){
        return search(root, num, 31);
    }
}

public class SumOfXOR_13504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int ans = 0;
            Trie4 trie = new Trie4();
            int prefix = 0;
            trie.add(prefix);
            int n = sc.nextInt();
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                prefix ^= num;
                trie.add(prefix);
                int temp = (trie.search(prefix) ^ prefix);
                if(ans < temp) ans = temp;
            }

            System.out.println(ans);


        }
    }
}

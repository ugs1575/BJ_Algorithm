package stringMatching.trie;

import java.util.ArrayList;
import java.util.Scanner;

class Trie6{
    class Node {
        boolean valid;
        int[] children;
        int[] cnt;
        Node(){
            valid = false;
            cnt = new int[2];
            children = new int[2];
            for(int i=0; i<2; i++){
                children[i] = -1;
                cnt[i] = 0;
            }
        }
    }
    int root;
    ArrayList<Node> trie;
    int init(){
        Node x = new Node();
        trie.add(x);
        return trie.size()-1;
    }
    Trie6() {
        trie = new ArrayList<>();
        root = init();
    }
    void add(int node, int number, int bit){
        if(bit == -1){
            trie.get(node).valid = true;
            return;
        }
        int c = (number >> bit) & 1;
        if(trie.get(node).children[c] == -1){
            int next = init();
            trie.get(node).children[c] = next;
        }
        trie.get(node).cnt[c] += 1;
        add(trie.get(node).children[c], number, bit-1);
    }
    void add(int number){
        add(root, number, 20);
    }
    int search(int node, int number, int bit, int k){
        //if(bit == -1) return 0;
        int c1 = (k >> bit) & 1;
        int c2 = (number >> bit) & 1;
        int ans = 0;

        if(c1 == 1){
            ans += trie.get(node).cnt[c2];
            c2 = 1-c2;
        }

        if(trie.get(node).children[c2] == -1) return ans;
        ans += search(trie.get(node).children[c2], number, bit-1, k);
        return ans;
    }

    int search(int number, int k){
        return search(root, number, 20, k);
    }
}
public class XOR_1344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long ans = 0;
        Trie6 trie = new Trie6();
        int prefix = 0;
        trie.add(0);
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            prefix ^= num;
            ans += trie.search(prefix, k);
            trie.add(prefix);
        }
        System.out.println(ans);

    }
}

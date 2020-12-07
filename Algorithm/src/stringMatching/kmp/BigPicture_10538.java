package stringMatching.kmp;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int pi;
    int valid;
    int[] children;
    Node() {
        pi = -1;
        valid = -1;
        children = new int[2];
        for(int i=0; i<2; i++){
            children[i] = -1;
        }
    }
}

public class BigPicture_10538 {
    static int rb, cb, rs, cs;
    static ArrayList<Node> trie = new ArrayList<Node>();
    static int root;
    static int[] preprocessing(String p){
        int m = p.length();
        int[] pi = new int[m];
        pi[0] = 0;
        int j = 0;
        for(int i=1; i<m; i++){
            while (j > 0 && p.charAt(i) != p.charAt(j)){
                j = pi[j-1];
            }

            if(p.charAt(i) == p.charAt(j)){
                pi[i] = j+1;
                j += 1;
            }else{
                pi[i] = 0;
            }
        }

        return pi;
    }
    static int kmp(String s, String p){
        int ans = 0;
        int[] pi = preprocessing(p);
        int n = s.length();
        int m = p.length();
        int j = 0;
        for(int i=0; i<n; i++){
            while (j > 0 && s.charAt(i) != p.charAt(j)){
                j = pi[j-1];
            }

            if(s.charAt(i) == p.charAt(j)){
                if(j == m-1){
                    ans += 1;
                    j = pi[j];
                }else{
                    j += 1;
                }
            }
        }

        return ans;
    }
    static int init(){
        Node x = new Node();
        trie.add(x);
        return trie.size()-1;
    }
    static void search(int node, String s, int row, int[][] check){
        for(int i=0; i<s.length(); i++){
            int c = 0;
            if('x' == s.charAt(i)){
                c = 1;
            }

            while (node != root && trie.get(node).children[c] == -1){
                node = trie.get(node).pi;
            }

            if(trie.get(node).children[c] != -1){
                node = trie.get(node).children[c];
            }

            if(trie.get(node).valid != -1){
                check[row][i] = trie.get(node).valid;
            }

        }
    }
    static void add(int node, String s, int index, int row, int[] temp){
        if(index == s.length()){
            trie.get(node).valid = node;
            temp[row] = node;
            return;
        }

        int c = 0;
        if('x' == s.charAt(index)){
            c = 1;
        }
        if(trie.get(node).children[c] == -1){
            int next = init();
            trie.get(node).children[c] = next;
        }

        int child = trie.get(node).children[c];
        add(child, s, index+1, row, temp);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        rs = Integer.parseInt(a[0]);
        cs = Integer.parseInt(a[1]);
        rb = Integer.parseInt(a[2]);
        cb = Integer.parseInt(a[3]);

        String[] small = new String[rs];
        String[] big = new String[rb];
        root = init();

        int[] temp = new int[rs];
        for(int i=0; i<rs; i++){
            small[i] = br.readLine();
            add(root, small[i], 0, i, temp);
        }

        Queue<Integer> q = new LinkedList<>();
        trie.get(root).pi = root;
        q.add(root);
        while (!q.isEmpty()){
            int cur = q.remove();
            for(int i=0; i<2; i++){
                int next = trie.get(cur).children[i];
                if(next == -1) continue;
                if(cur == root){
                    trie.get(next).pi = root;
                }else{
                    int x = trie.get(cur).pi;
                    while (x != root && trie.get(x).children[i] == -1){
                        x = trie.get(x).pi;
                    }

                    if(trie.get(x).children[i] != -1){
                        x = trie.get(x).children[i];
                    }

                    trie.get(next).pi = x;

                }
                q.add(next);
            }
        }


        int[][] check = new int[rb][cb];
        for(int i=0; i<rb; i++){
            big[i] = br.readLine();
            search(root, big[i], i, check);
        }

        StringBuilder sb = new StringBuilder();
        for(int i:temp){
            sb.append(i);
        }


        String p = sb.toString();
        int ans = 0;
        for(int j=cs-1; j<cb; j++){
            sb = new StringBuilder();
            for(int i=0; i<rb; i++){
                sb.append(check[i][j]);
            }
            String s = sb.toString();
            ans += kmp(s, p);

        }

        System.out.println(ans);
    }
}

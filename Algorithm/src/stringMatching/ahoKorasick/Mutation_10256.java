package stringMatching.ahoKorasick;

import java.util.*;

class Node2{
    int pi;
    int valid;
    int[] children;
    ArrayList<Integer> indexes;
    Node2(){
        pi = -1;
        valid = -1;
        children = new int[26];
        for(int i=0; i<26; i++){
            children[i] = -1;
        }
        indexes = new ArrayList<>();
    }
}

public class Mutation_10256 {
    static int n, m;
    static String s, p;
    static HashSet<String> pattern;
    static ArrayList<Node2> trie;
    static void add(int node, String txt, int index, int string_index){
        if(index == m){
            trie.get(node).valid = string_index;
            return;
        }

        int c = txt.charAt(index) - 'A';
        if(trie.get(node).children[c] == -1){
            int next = init();
            trie.get(node).children[c] = next;
        }

        int child = trie.get(node).children[c];
        add(child, txt, index+1, string_index);
    }
    static int init(){
        Node2 x = new Node2();
        trie.add(x);
        return trie.size()-1;
    }
    static void divide(int start, int end, int index, int[] temp){
        if(index == temp.length){
            StringBuilder sb = new StringBuilder();
            String first = "";
            String third = "";
            if(temp[0] > 0){
                first = p.substring(0,temp[0]);
            }
            if(temp[1] < m){
                third = p.substring(temp[1], m);
            }
            String second = p.substring(temp[0], temp[1]);
            sb.append(second);
            second = sb.reverse().toString();
            String m = first+second+third;
            pattern.add(m);
            return;
        }

        for(int i=start; i<end; i++){
            temp[index] = i;
            divide(i+1, end, index+1, temp);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            n = sc.nextInt();
            m = sc.nextInt();
            s = sc.next();
            p = sc.next();
            pattern = new HashSet<>();
            trie = new ArrayList<>();
            int[] temp = new int[2];
            divide(0, m+1, 0, temp); // 모든 마커 담기

            int string_index = 0;
            int root = init();
            for(String marker:pattern){
                add(root, marker, 0, string_index++);
            }

            Queue<Integer> q = new LinkedList<>();
            trie.get(root).pi = root;
            q.add(root);
            while (!q.isEmpty()){
                int cur = q.remove();
                for(int i=0; i<26; i++){
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
                    int pi = trie.get(next).pi;
                    trie.get(next).indexes = new ArrayList<>(trie.get(pi).indexes);
                    if(trie.get(next).valid != -1){
                        trie.get(next).indexes.add(trie.get(next).valid);
                    }
                    q.add(next);
                }
            }


            int ans = 0;
            int node = root;
            //찾기
            for(int i=0; i<n; i++){
                int c = s.charAt(i) - 'A';
                while (node != root && trie.get(node).children[c] == -1){
                    node = trie.get(node).pi;
                }
                if(trie.get(node).children[c] != -1){
                    node = trie.get(node).children[c];
                }
                if(trie.get(node).indexes.size() > 0){
                    ans += 1;
                }
            }

            System.out.println(ans);
        }
    }
}

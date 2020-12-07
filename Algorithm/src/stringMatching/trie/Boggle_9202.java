package stringMatching.trie;

import java.util.*;
class Node {
    boolean valid;
    int[] children;
    Node() {
        valid = false;
        children = new int[26];
        for(int i=0; i<26; i++){
            children[i] = -1;
        }
    }
}

public class Boggle_9202 {
    static int[] dx = {0,0,1,-1,1,1,-1,-1};
    static int[] dy = {1,-1,0,0,1,-1,1,-1};
    static int[] scores = {0,0,0,1,1,2,3,5,11};
    static boolean[][] check = new boolean[4][4];
    static ArrayList<Node> trie = new ArrayList<>();
    static int init(){
        Node x = new Node();
        trie.add(x);
        return trie.size()-1;
    }
    static void add(int node, String s, int index){
        if(index == s.length()){
            trie.get(node).valid = true;
            return;
        }
        int c = s.charAt(index)-'A';
        if(trie.get(node).children[c] == -1){
            int next = init();
            trie.get(node).children[c] = next;
        }
        add(trie.get(node).children[c], s, index+1);
    }
    static void search(int x, int y, String s, int node, String[] board, ArrayList<String> words){
        if(check[x][y]){
            return;
        }
        if(s.length() == 8){
            return;
        }
        check[x][y] = true;
        int c = board[x].charAt(y) - 'A';
        int next = trie.get(node).children[c];
        if(next == -1){
            check[x][y] = false;
            return;
        }
        String str = s + board[x].charAt(y);
        if(trie.get(next).valid){
            words.add(str);
        }
        for(int k=0; k<8; k++){
            int nx = x+dx[k];
            int ny = y+dy[k];
            if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
            search(nx, ny, str, next, board, words);
        }
        check[x][y] = false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int root = init();
        String[] dictionary = new String[n];
        for(int i=0; i<n; i++){
            dictionary[i] = sc.next();
            add(root, dictionary[i], 0);
        }
        int t = sc.nextInt();
        while (t-- > 0){
            String[] board = new String[4];
            for(int i=0; i<4; i++){
                board[i] = sc.next();
            }
            ArrayList<String> words = new ArrayList<>();
            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    search(i, j, "", root, board, words);
                }
            }

            HashSet<String> wordset = new HashSet<>(words);
            words = new ArrayList<String>(wordset);
            Collections.sort(words);
            int score = 0;
            String longest = "";
            int cnt = words.size();
            for(String a : words){
                score += scores[a.length()];
                if(longest.length() < a.length()){
                    longest = a;
                }else if(longest.length() == a.length() && longest.compareTo(a) > 0){
                    longest = a;
                }
            }
            System.out.println(score+" "+longest+" "+cnt);
        }
    }
}
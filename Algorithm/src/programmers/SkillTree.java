package programmers;

import java.util.ArrayList;

class Node{
    boolean valid;
    int[] children;
    Node(){
        valid = false;
        children = new int[26];
        for(int i=0; i<26; i++){
            children[i] = -1;
        }
    }
}

public class SkillTree {
    static ArrayList<Node> trie = new ArrayList<>();
    static boolean search(int root, String skill, int index){
        if(index == skill.length()){
            return true;
        }

        int c = skill.charAt(index) - 'A';
        if(trie.get(root).children[c] == -1){
            return false;
        }

        return search(trie.get(root).children[c], skill, index+1);
    }
    static void add(int root, String skill, int index){
        if(index == skill.length()){
            trie.get(root).valid = true;
            return;
        }
        int c = skill.charAt(index)-'A';
        if(trie.get(root).children[c] == -1){
            int next = init();
            trie.get(root).children[c] = next;
        }

        add(trie.get(root).children[c], skill, index+1);
    }
    static int init(){
        Node x = new Node();
        trie.add(x);
        return trie.size()-1;
    }
    static int solution(String skill, String[] skill_trees) {
        int n = skill.length();
        int m = skill_trees.length;
        boolean[] check = new boolean[26];
        for(char c : skill.toCharArray()){
            check[c-'A'] = true;
        }

        int root = init();
        add(root, skill, 0);


        String[] a = new String[m];
        for(int i=0; i<m; i++){
            StringBuilder sb = new StringBuilder();
            for(char c : skill_trees[i].toCharArray()){
                if(check[c-'A']){
                    sb.append(c);
                }
            }
            a[i] = sb.toString();
        }

        int answer = 0;
        for(String s : a){
            if(search(root, s, 0)){
                answer += 1;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA", "CBD", "CAFB"};
        System.out.println(solution(skill, skill_trees));
    }
}

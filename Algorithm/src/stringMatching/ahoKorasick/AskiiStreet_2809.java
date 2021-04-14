/*
* 아호코라식 알고리즘을 이용해서 모든 부분 문자열을 찾고 매치될 때마다
* 시작 인덱스와 끝 인덱스를 따로 저장했다.
*
* 이제 저장된 인덱스를 이용해 교체할 수 있는 타일의 수를 구한다.
*
* N에서 위에서 구한 값을 빼면 정답이다.
*
* 예를 들어 인덱스가 1~3, 2~5 이렇게 나오면
* 이부분의 길이는 문제 선긋기와 동일한 방법으로 구할 수 있다.
* 시작점을 만났을 때는 +1, 끝나는 점을 만났을 때는 -1 (접하는 것을 교차로 보지 않을 경우 끝나는 점부터 먼저 처리해야한다)
* 처리해주고 0->1 되는 순간 길이의 시작지점
* 1->0이 되는 순간 길이가 끝나는 지점이다
*
* 교체할 수있는 부분의 길이를 구해주고 전체 길이 에서 빼주면 된다.
*
* */

package stringMatching.ahoKorasick;

import java.util.*;

class Pair implements Comparable<Pair>{
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair that) {
        if(this.first < that.first){
            return -1;
        }else if(this.first == that.first){
            if(this.second < that.second){
                return -1;
            }else if(this.second == that.second){
                return 0;
            }else{
                return 1;
            }
        }else{
            return 1;
        }
    }
}

class Node3{
    int valid;
    int[] children;
    int pi;
    int len;
    Node3(){
        children = new int[26];
        for(int i=0; i<26; i++){
            children[i] = -1;
        }
        pi = -1;
        len = 0;
    }
}

public class AskiiStreet_2809 {
    static ArrayList<Node3> trie = new ArrayList<>();
    static int init(){
        Node3 x = new Node3();
        trie.add(x);
        return trie.size()-1;
    }
    static void add(int node, String s, int index, int string_index){
        if(index == s.length()){
            trie.get(node).len = index;
            return;
        }
        int c = s.charAt(index) - 'a';
        if(trie.get(node).children[c] == -1){
            int next = init();
            trie.get(node).children[c] = next;
        }

        add(trie.get(node).children[c], s, index+1, string_index);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int m = sc.nextInt();
        int root = init();
        for(int i=0; i<m; i++){
            String temp = sc.next();
            add(root, temp, 0, i);
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
                trie.get(next).len = Math.max(trie.get(next).len, trie.get(pi).len);
                q.add(next);
            }
        }
        int node = root;
        boolean ok = false;
        ArrayList<Pair> matches = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            int c = s.charAt(i) - 'a';
            while (node != root && trie.get(node).children[c] == -1){
                node = trie.get(node).pi;
            }
            if(trie.get(node).children[c] != -1){
                node = trie.get(node).children[c];
            }
            if(trie.get(node).len > 0){
                matches.add(new Pair(i-trie.get(node).len+1, -1)); //시작 인덱스
                matches.add(new Pair(i, 1)); //끝 인덱스
            }
        }
        Collections.sort(matches);
        int ans = 0;
        int start = 0;
        int open = 0;
        for(Pair p : matches){
            if(p.second == -1){
                if(open == 0) start = p.first;
                open += 1;
            }else{
                open -= 1;
                if(open == 0) ans += p.first - start + 1;
            }
        }
        ans = n - ans;
        System.out.println(ans);

    }
}

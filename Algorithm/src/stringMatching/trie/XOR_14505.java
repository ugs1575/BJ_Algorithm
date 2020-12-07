package stringMatching.trie;

import java.io.*;
import java.util.ArrayList;

class Trie3{
    class Node{
        int[] children;
        boolean valid;
        Node(){
            children = new int[2];
            for(int i=0; i<2; i++){
                children[i] = -1;
            }
            valid = false;
        }
    }
    int init(){
        Node x = new Node();
        trie.add(x);
        return trie.size()-1;
    }
    ArrayList<Node> trie;
    int root;
    Trie3(){
        trie = new ArrayList<Node>();
        root = init();
    }
    void add(int node, int number, int bit){
        if(bit == -1) return;
        int c = (number>>bit) & 1; //bit가 무엇인지 구한다
        if(trie.get(node).children[c] == -1){
            int next = init();
            trie.get(node).children[c] = next;
        }
        int child = trie.get(node).children[c];
        add(child, number, bit-1);
    }
    void add(int number){
        add(root, number, 31); //가장 큰 비트, 31번째 비트 부터 추가한다.
    }
    int search(int node, int number, int bit){
        int c = (number>>bit) & 1; //bit가 무엇인지 구한다
        c = 1-c; //xor해서 큰값이 나와야하기 때문에 반대값을 찾는다
        if(trie.get(node).children[c] == -1){ //그 값에 반대값이 없으면 다른 걸로 넘어가야하기 때문에
            c = 1-c; //다시 반대
        }
        if(trie.get(node).children[c] == -1){ //거의 이런경우는 없다 무조건 둘중 하나는 존재하기 때문
            return 0;
        }
        int next = 0; //해당 비트와 와야하는 값을 구했다
        if(c == 1) next = (1 << bit); //1일때는 해당비트에 1추가
        return next | search(trie.get(node).children[c], number, bit-1); //호출하면서 값을 추가해준다.
    }
    int search(int number){
        return search(root, number, 31); //마찬가지로 가장큰 비트 31비트 부터 검사한다.
    }

}

public class XOR_14505 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        Trie3 trie = new Trie3();
        int ans = 0;
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(s[i]);
            trie.add(x);
            int temp = (trie.search(x)^x);
            if(ans < temp) ans = temp;
        }

        System.out.println(ans);
    }
}

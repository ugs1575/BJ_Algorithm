package graph.bfs;

import java.util.*;

public class TreeTraverse_1991 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int nodeCnt = sc.nextInt();
        sc.nextLine();

        int[][] aTree = new int[26][2];
        for(int i=0; i<nodeCnt; i++){
            String str = sc.nextLine();
            char cNode = str.charAt(0);
            int iNode = cNode-65;
            char cLeft = str.charAt(2);
            char cRight = str.charAt(4);
            if(cLeft != '.'){
                int left = cLeft;
                aTree[iNode][0] = left;
            }
            if(cRight != '.'){
                int right = cRight;
                aTree[iNode][1] = right;
            }



        }
        preOrder(0,aTree);
        System.out.println();
        inOrder(0,aTree);
        System.out.println();
        postOrder(0,aTree);
    }

    public static void preOrder(int n, int[][] aTree){
        //노드출력
        char node = (char) (n+65);
        System.out.print(node);
        //왼쪽자식 프리오더
        if(aTree[n][0] != 0){
            char cLeft = (char)aTree[n][0];
            int iLeft = cLeft-65;
            preOrder(iLeft, aTree);
        }

        //오른쪽 자식 프리오더
        if(aTree[n][1] != 0){
            char cRight = (char)aTree[n][1];
            int iRight = cRight-65;
            preOrder(iRight, aTree);
        }

    }

    public static void inOrder(int n, int[][] aTree){
        //왼쪽자식 프리오더
        if(aTree[n][0] != 0){
            char cLeft = (char)aTree[n][0];
            int iLeft = cLeft-65;
            inOrder(iLeft, aTree);
        }

        //노드출력
        char node = (char) (n+65);
        System.out.print(node);

        //오른쪽 자식 프리오더
        if(aTree[n][1] != 0){
            char cRight = (char)aTree[n][1];
            int iRight = cRight-65;
            inOrder(iRight, aTree);
        }

    }

    public static void postOrder(int n, int[][] aTree){
        //왼쪽자식 프리오더
        if(aTree[n][0] != 0){
            char cLeft = (char)aTree[n][0];
            int iLeft = cLeft-65;
            postOrder(iLeft, aTree);
        }

        //오른쪽 자식 프리오더
        if(aTree[n][1] != 0){
            char cRight = (char)aTree[n][1];
            int iRight = cRight-65;
            postOrder(iRight, aTree);
        }

        //노드출력
        char node = (char) (n+65);
        System.out.print(node);

    }
}

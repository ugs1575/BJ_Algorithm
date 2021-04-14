package programmers;

import java.util.ArrayList;

class Block{
    char friend;
    boolean remove;

    public Block(char friend, boolean remove) {
        this.friend = friend;
        this.remove = remove;
    }
}

public class FriendsFourBlocks {
    static int[] dx = {0,1,1,0};
    static int[] dy = {1,0,1,0};
    public int solution(int m, int n, String[] board) {
        ArrayList<Character>[] list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }

        //초기 게임 세팅
        Block[][] game = new Block[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                game[i][j] = new Block(board[i].charAt(j), false);
            }
        }

        int cnt = 0;
        while (true){
            boolean stop = true;
            //4개 블록 체크
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(game[i][j] == null) continue;
                    char cur = game[i][j].friend;

                    //2x2로 만들어지는지 확인
                    boolean ok = true;
                    for(int k=0; k<3; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        //범위 빠져나가는 거 체크
                        if(nx >= m || ny >= n) {
                            ok = false;
                            break;
                        }
                        //같은 알파벳 아니면
                        if(game[nx][ny] == null || game[nx][ny].friend != cur) {
                            ok = false;
                        }
                    }

                    //2x2가 맞다
                    if(ok){
                        for(int k=0; k<4; k++){
                            int nx = i+dx[k];
                            int ny = j+dy[k];
                            if(!game[nx][ny].remove){
                                cnt += 1;
                                game[nx][ny] = new Block(game[nx][ny].friend, true);
                            }
                        }
                        stop = false;
                    }

                }
            }
            //지워질 것이 없다면 끝낸다.
            if(stop) break;

            //행별로 지워진걸 제외하고 넣는다.
            for(int j=0; j<n; j++){
                for(int i=m-1; i>=0; i--){
                    if(game[i][j] != null && !game[i][j].remove){
                        list[j].add(game[i][j].friend);
                    }
                }
            }


            //게임판 초기화 하고 다시 셋팅
            game = new Block[m][n];
            for(int j=0; j<n; j++){
                int row = m-1;
                for(int i=0; i<list[j].size(); i++){
                    game[row--][j] = new Block(list[j].get(i), false);
                }
            }

            list = new ArrayList[n];
            for(int i=0; i<n; i++){
                list[i] = new ArrayList<>();
            }
        }

        int answer = cnt;
        return answer;
    }

    public static void main(String[] args) {
        FriendsFourBlocks f = new FriendsFourBlocks();
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        f.solution(m, n, board);
    }
}

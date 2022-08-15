import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Tomato {
    int x; //세로
    int y; //가로
    int z; //면

    Tomato(int z, int y, int x){
        this.z = z;
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int M; // 가로
    static int N; // 세로
    static int H; // 높이

    static int[] dx = { -1, 0, 1, 0, 0, 0 }; //상하좌우위아래
    static int[] dy = { 0, 1, 0, -1, 0, 0 }; //상하좌우위아래
    static int[] dz = { 0, 0, 0, 0, 1, -1 }; //상하좌우위아래

    static int[][][] board;
    static Queue<Tomato> queue;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H][M][N];
        queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    //정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토 X
                    board[i][j][k] = Integer.parseInt(st.nextToken());
//                    System.out.println("i = " + i + ", j = " + j + ", k = " + k);
                    if(board[i][j][k] == 1) {
                        queue.add(new Tomato(i, j, k));
                    }
                }
            }
        }
        System.out.println(bfs());
    }
    public static int bfs() {
        while(!queue.isEmpty()) {
            Tomato tomato = queue.remove();

            int z = tomato.z; //면
            int y = tomato.y; //가로
            int x = tomato.x; //세로

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i]; //세로
                int ny = y + dy[i]; //가로
                int nz = z + dz[i]; //면

                //범위 안에서
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H) {
                    //토마토가 안익었으면
                    if (board[nz][ny][nx] == 0) {
                        //익은 토마토 추가
                        queue.add(new Tomato(nz, ny, nx));

                        //익은 날자를 얻기위해 그 전 값에서 1 증가
                        board[nz][ny][nx] = board[z][y][x] + 1;
                    }
                }
            }
        }

        //최대 날짜
        int result = Integer.MIN_VALUE;


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    //토마토가 안익은게 있으면
                    if (board[i][j][k] == 0) return -1;

                    //날짜 최댓값 구하기
                    result = Math.max(result, board[i][j][k]);
                }
            }
        }

        //토마토가 모두 익은 상태인 경우
        if (result == 1) {
            return 0;
        } else { //걸린 일수는 최대 날짜에서 1을 빼줘야 함
            return result - 1;
        }
    }
}
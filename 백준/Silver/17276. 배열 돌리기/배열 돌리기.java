import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,d;
    static int x,y; //배열위치
    static int start,end; //시작점, 끝점
    static int[][]arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 45도만큼 돌리기
            for (int i = 0; i < (Math.abs(d) % 360) / 45; i++) {
                int move = N / 2; //처음에 이동하는 칸 수
                end = N - 1; // 끝점

                for (int j = 0; j < N / 2; j++) {
                    start = j; // 시작점

                    if (d < 0) { //반시계방향
                        antiClock(move);
                    } else { //시계방향
                        clock(move);
                    }

                    move--; // 이동하는 칸수
                    end--; // 배열의 안쪽으로 들어온다
                    start++; // 배열의 안쪽으로 들어온다
                }
            }
            Tostring(); // 정답저장
        }
        System.out.println(sb);
    }

    private static void Tostring() {
        for (int i = 0; i < N; i++) {
            for(int j = 0; j< N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    //반시계방향
    private static void antiClock(int move) {
        x = y = start;
        int tmp = arr[x][y];
        for (int j = y; j <= end - move; j += move) {
            arr[x][j] = arr[x][j + move];
        }

        y = end;
        for (int i = x; i <= end - move; i += move) {
            arr[i][y] = arr[i + move][y];
        }

        x = end;
        for (int j = y; j >= start + move; j -= move) {
            arr[x][j] = arr[x][j - move];
        }

        y = start;
        for (int i = x; i > start + move; i -= move) {
            arr[i][y] = arr[i - move][y];
        }
        x = start + move;
        arr[x][y] = tmp;
    }

    //시계방향
    private static void clock(int move) {
        x = y = start;
        int tmp = arr[x][y];
        for (int i = x; i <= end - move; i += move) {
            arr[i][y] = arr[i + move][y];
        }
        x = end;
        for (int j = y; j <= end - move; j += move) {
            arr[x][j] = arr[x][j + move];
        }
        y = end;
        for (int i = x; i >= start + move; i -= move) {
            arr[i][y] = arr[i - move][y];
        }
        x = start;
        for (int j = y; j > start + move; j -= move) {
            arr[x][j] = arr[x][j - move];
        }

        y = start + move;
        arr[x][y] = tmp;
    }
}
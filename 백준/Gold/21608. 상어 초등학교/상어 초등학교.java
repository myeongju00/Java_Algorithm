import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point implements Comparable<Point> { //좌표와 좋아요 수, 인접한 좋아요 수를 저장할 클래스
    int x, y, nearCount, likeCount;

    public Point(int y, int x, int nearCount, int likeCount) {
        this.y = y;
        this.x = x;
        this.nearCount = nearCount;
        this.likeCount = likeCount;
    }
    @Override
    public int compareTo(Point o2) {
        // 인접 좋아하는 학생 수로 비교
        if (likeCount != o2.likeCount) return -(likeCount - o2.likeCount);

        // 인접 빈칸 수로 비교
        if (nearCount != o2.nearCount) return -(nearCount - o2.nearCount);

        // 행으로 비교
        if (x != o2.x) return x - o2.x;

        // 열로 비교
        return y - o2.y;
    }
}

public class Main {
    static int[][] board;
    static int[] students;
    static List<Integer>[] list; // 좋아하는 학생들을 저장할 리스트
    static PriorityQueue<Point> queue = new PriorityQueue<>();
    static int N;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N + 1][N + 1];
        students = new int[N * N + 1];
        list = new ArrayList[N * N + 1];

        for (int i = 1; i <= N * N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            students[i] = student;

            for (int j = 0; j < 4; j++) {
                list[student].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= N * N; i++) {
            solve(students[i]);
            queue.clear();
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result += getScore(i, j);
            }
        }
        System.out.println(result);
    }

    private static int getScore(int y, int x) {
        int number = board[y][x];
        int nx, ny, likeCount = 0;
        for(int now : list[number]) {
            for (int i = 0; i < 4; i++) {
                ny = y + dy[i];
                nx = x + dx[i];
                if (ny >= 1 && ny <= N && nx >= 1 && nx <= N) {
                    if(board[ny][nx] == now){
                        likeCount++;
                    }
                }
            }
        }
        if(likeCount == 0) {
            return 0;
        } else if(likeCount == 1) {
            return 1;
        } else if(likeCount == 2) {
            return 10;
        } else if(likeCount == 3) {
            return 100;
        } else {
            return 1000;
        }
    }
    private static void solve(int number) {
        int nx, ny, nearCount, likeCount;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                nearCount = 0;
                likeCount = 0;
                if(board[i][j] != 0) {
                    continue;
                }
                for (int k = 0; k < 4; k++) { //사방 탐색
                    ny = i + dy[k];
                    nx = j + dx[k];
                    if(ny >= 1 && nx >=1 && ny <= N && nx <= N) {
                        for(Integer now : list[number]) {
                            if(now == board[ny][nx]) {
                                likeCount++;
                            }
                        }
                        if(board[ny][nx] == 0) {
                            nearCount++;
                        }
                    }
                }
                queue.add(new Point(i, j, nearCount, likeCount));
            }
        }
        Point poll = queue.poll();
        board[poll.y][poll.x] = number;
    }

}
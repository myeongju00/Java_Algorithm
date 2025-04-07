class Solution {
    private final int[] dx = {0, 1, -1};
    private final int[] dy = {1, 0, -1};
    private static int[][] board;
    private static int value = 1;
    private static int N;

    public int[] solution(int n) {
        N = n;
        board = new int[n][n];
        board[0][0] = 1;

        move(0, 0, 0);

        int[] result = new int[n * (n + 1) / 2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j= 0; j <= i; j++) {
                result[index++] = board[i][j];
            }
        }
        return result;
    }

    private void move(int y, int x, int dir) {
        while (true) {
            board[y][x] = value++;
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx == N || ny == N ||  nx < 0 ||  ny < 0 || board[ny][nx] != 0) {
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
                if(nx == N || ny == N || nx < 0 || ny < 0 || board[ny][nx] != 0) {
                    break;
                }
            }
            x = nx;
            y = ny;
        }
    }

}
class Solution {

    String[][] board;
    boolean[][] visited;
    int[] dh = {1, 0, 0, -1};
    int[] dw = {0, 1, -1, 0};
    int count = 0;
    public int solution(String[][] board, int h, int w) {
        this.board = board;
        this.visited = new boolean[board.length][board[0].length];
        dfs(h, w);
        return count;
    }

    private void dfs (int h, int w) {
        visited[h][w] = true;

        for (int i = 0; i < 4; i++) {
            int nh = h + dh[i];
            int nw = w + dw[i];

            if (nh < 0 || nh >= board.length ||
                nw < 0 || nw >= board[0].length || visited[nh][nw]) {
                continue;
            }
            if (board[nh][nw].equals(board[h][w])) {
                count++;
            }
        }
    }

}
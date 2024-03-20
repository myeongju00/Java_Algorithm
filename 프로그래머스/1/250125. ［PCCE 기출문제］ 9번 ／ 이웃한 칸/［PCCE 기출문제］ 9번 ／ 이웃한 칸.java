class Solution {

    String[][] board;
    int[] dh = {1, 0, 0, -1};
    int[] dw = {0, 1, -1, 0};
    int count = 0;
    public int solution(String[][] board, int h, int w) {
        this.board = board;
        dfs(h, w);
        return count;
    }

    private void dfs (int h, int w) {
        for (int i = 0; i < 4; i++) {
            int nh = h + dh[i];
            int nw = w + dw[i];

            if (nh < 0 || nh >= board.length ||
                nw < 0 || nw >= board[0].length) {
                continue;
            }
            if (board[nh][nw].equals(board[h][w])) {
                count++;
            }
        }
    }

}
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String[] solution(int[][] line) {

        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for(int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2],
                                                  line[j][0], line[j][1], line[j][2]);
                if(intersection != null) {
                    points.add(intersection);
                }
            }
        }

        Point minimumPoint = getMinimumPoint(points);
        Point maximumPoint = getMaximumPoint(points);

        int width = (int) (maximumPoint.x - minimumPoint.x + 1);
        int height = (int) (maximumPoint.y - minimumPoint.y + 1);

        char[][] board = new char[height][width];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        for(Point point : points) {
            int x = (int) (point.x - minimumPoint.x);
            int y = (int) (maximumPoint.y - point.y);
            board[y][x] = '*';
        }

        String[] result = new String[board.length];
        for (int i = 0; i < board.length; i++) {
            result[i] = new String(board[i]);
        }
        return result;
    }

    private Point intersection(long al, long b1, long c1,
                               long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (al * b2 - a2 * b1);
        double y = (double) (c1 * a2 - c2 * al) / (al * b2 - a2 * b1);

        if(x % 1 != 0 || y % 1 != 0)  {
            return null;
        }

        return new Point((long) x, (long) y);
    }

    private Point getMinimumPoint(ArrayList<Point> points) {
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        for(Point point : points) {
            minX = Math.min(minX, point.x);
            minY = Math.min(minY, point.y);
        }
        return new Point(minX, minY);
    }

    private Point getMaximumPoint(ArrayList<Point> points) {
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        for(Point point : points) {
            maxX = Math.max(maxX, point.x);
            maxY = Math.max(maxY, point.y);
        }
        return new Point(maxX, maxY);
    }

    public static void main(String[] args) {
    }

    private static class Point {
        public final long x, y;
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}

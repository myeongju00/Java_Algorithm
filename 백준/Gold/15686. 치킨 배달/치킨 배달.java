import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int M, result = Integer.MAX_VALUE;
    static int[][] board;
    static ArrayList<Node> chickenList = new ArrayList<>(); //치킨집 위치를 저장하는 리스트
    static ArrayList<Node> houseList = new ArrayList<>(); // 집의 위치를 저장하는 리스트
    static boolean[] chickenVisited; // 뽑은 치킨집 체크

    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) houseList.add(new Node(i, j));
                else if(board[i][j] == 2) chickenList.add(new Node(i, j));
            }
        }


        chickenVisited = new boolean[chickenList.size()];
        backtracking(0, 0); //m개의 치킨집을 뽑는다.
        System.out.println(result);
    }

    public static void backtracking(int count, int idx) {
        if(count == M) { //치킨 거리의 최솟값을 구한다.
            int total = 0; // 도시의 치킨거리
            for (Node node : houseList) {
                int sum = Integer.MAX_VALUE;
                for (int j = 0; j < chickenList.size(); j++) {
                    if (chickenVisited[j]) { //i번째 집에서부터 j번짜 치킨집 까지의 거리 중 최소값을 구한다.
                        int dist = Math.abs(node.x - chickenList.get(j).x)
                                + Math.abs(node.y - chickenList.get(j).y);
                        sum = Math.min(sum, dist);
                    }
                }
                total += sum;
            }
            result = Math.min(total, result);
            return;
        }

        for(int i = idx; i < chickenList.size(); i++) {
            if(!chickenVisited[i]) {
                chickenVisited[i] = true;
                backtracking(count + 1, i + 1);
                chickenVisited[i] = false;
            }
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int id;
        int h, w;

        Node(int h, int w, int id){
            this.h = h;
            this.w = w;
            this.id = id;
        }
    }
    static boolean[][] map;
    static ArrayList<Node> list;
    static boolean[] isUsed;
    static int H, W, N;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        ans = 0;
        map = new boolean[H][W];
        isUsed = new boolean[N];
        list = new ArrayList<>();

        for(int i = 0 ; i < N ; ++i) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Node(h, w, i));
            list.add(new Node(w, h, i));
        }

        go(0, 0);

        System.out.println(ans);
    }

    private static void go(int cnt, int size) {
        if(cnt == 2) {
//            ans = size > ans ? size : ans;
            ans = Math.max(ans, size);
            return;
        }
        for(Node sticker : list) {
            if(isUsed[sticker.id]) continue;

            Node start = findStart(sticker);
            if(start == null) continue;

            attach(start, sticker, true);
            isUsed[sticker.id] = true;
            go(cnt + 1, size + sticker.h * sticker.w);
            isUsed[sticker.id] = false;
            attach(start, sticker, false);
        }
    }

    private static Node findStart(Node sticker) {
        for(int r = 0 ; r <= H - sticker.h ; ++r) {
            for(int c = 0 ; c <= W - sticker.w ; ++c) {
                if(map[r][c]) continue;

                boolean canAttach = true;
                for(int i = r ; i < r + sticker.h ; ++i) {
                    for(int j = c ; j < c + sticker.w ; ++j) {
                        if(map[i][j]) {
                            canAttach = false;
                            break;
                        }
                    }
                    if(!canAttach) break;
                }
                if(canAttach) return new Node(r, c, -1);
            }
        }
        return null;
    }

    private static void attach(Node start, Node sticker, boolean type) {
        for(int r = start.h ; r < start.h + sticker.h ; ++r) {
            for(int c = start.w ; c < start.w + sticker.w ; ++c) {
                map[r][c] = type;
            }
        }
    }
}
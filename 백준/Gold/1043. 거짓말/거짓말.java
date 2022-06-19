import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static boolean[] TruePeople = new boolean[51];
    static int[] parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 파티의 수

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        //진실을 아는 사람 정보
        for (int i = 0; i < num; i++) {
            TruePeople[Integer.parseInt(st.nextToken())] = true;
        }

        // 같은 파티에 있는 사람들 union
        HashSet<Integer>[] parties = new HashSet[M + 1];
        for (int i = 0; i < M; i++) {
            parties[i] = new HashSet<>();
        }

        for (int i = 0; i < M; i++) {
            //파티정보 받아오기
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int a = 0, b = 0;
            if(n < 2) {
                a = Integer.parseInt(st.nextToken());
                parties[i].add(a);
                continue;
            }
            a = Integer.parseInt(st.nextToken());
            for (int j = 1; j < n; j++) { //연관관계 설정
                b = Integer.parseInt(st.nextToken());
                if(find(a) != find(b)) {
                    union(a, b);
                }
                parties[i].add(a);
                parties[i].add(b);
                a = b;
            }

        }

        // 진실을 아는 사람과 연관 관계 있음 => people_know[i] T로 변경
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if(TruePeople[i] && !visited[i]){
                int root = find(i);
                for (int j = 1; j <= N; j++){
                    if (find(j)==root) {
                        TruePeople[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        // 모든 파티 참석자가 F여야 과장된 얘기를 할 수 있음
        int result = 0;
        for (int i = 0; i < M; i++) { // party
            boolean flag = false;
            for (int person : parties[i]) { // 참석자
                if(TruePeople[person]){
                    flag = true;
                    break;
                }
            }
            if(!flag) result++;
        }
        System.out.println(result);
    }

    private static int find(int x) {
        if(parent[x] == x){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        int parent_b = find(b);
        parent[parent_b] = a; // b의 parent를 a로 변경
    }
}
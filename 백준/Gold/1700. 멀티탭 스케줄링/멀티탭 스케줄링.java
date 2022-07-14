import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //멀티탭 구멍의 개수
        int K = Integer.parseInt(st.nextToken()); //전기 용품의 총 사용횟수

        int[] arr = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[101];
        int put = 0;
        int result = 0;

        for (int i = 0; i < K; i++) {
            if(!visited[arr[i]]) {
                if(put < N) {
                    visited[arr[i]] = true;
                    put++;
                } else { // 공간이 없는 경우
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int j = i; j < K; j++) { // 현재 꽂혀 있는 콘센트가 나중에도 사용되는지 확인
                        if(visited[arr[j]] && !arrayList.contains(arr[j])) {
                            arrayList.add(arr[j]);
                        }
                    }

                    if(arrayList.size() != N) { // 나중에도 사용되는 콘센트 < 구멍의 개수
                        for (int j = 0; j < visited.length; j++) {
                            if(visited[j] && !arrayList.contains(j)) {
                                visited[j] = false;
                                break;
                            }
                        }
                    } else { // 현재 꽂혀 있는 모든 콘센트가 나중에도 사용될 경우
                        // 가장 마지막에 사용될 콘센트 제거
                        int remove = arrayList.get(arrayList.size() -1);
                        visited[remove] = false;
                    }
                    visited[arr[i]] = true;
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}

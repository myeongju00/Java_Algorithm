import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        int answer = 0;
        
        if (map.size() == 1) {
            // 4개 같은 수
            answer = 1111 * keys.get(0);
        } else if (map.size() == 2) {
            int x = keys.get(0);
            int y = keys.get(1);
            int cx = map.get(x);
            int cy = map.get(y);
            
            if (cx == 3 || cy == 3) {
                // pppq
                int p = (cx == 3) ? x : y;
                int q = (cx == 1) ? x : y;
                answer = (10 * p + q) * (10 * p + q);
            } else {
                // ppqq
                answer = (x + y) * Math.abs(x - y);
            }
        } else if (map.size() == 3) {
            // pprq
            int p = 0, q = 0;
            for (int key : keys) {
                if (map.get(key) == 2) {
                    p = key;
                } else if (q == 0) {
                    q = key;
                } else {
                    answer = q * key;
                }
            }
        } else {
            // 모두 다른 숫자
            answer = Arrays.stream(arr).min().getAsInt();
        }

        return answer;
    }
}
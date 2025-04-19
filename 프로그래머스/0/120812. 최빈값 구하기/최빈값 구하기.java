import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        int answer = -1;
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > max) {
                max = value;
                answer = key;
                count = 1;
            } else if (value == max) {
                count++;
            }
        }

        return (count > 1) ? -1 : answer;
    }
}
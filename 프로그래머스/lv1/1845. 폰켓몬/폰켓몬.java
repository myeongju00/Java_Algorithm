import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        
        for(int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        
        int max = nums.length / 2;
        
        return Math.min(hashMap.size(), max);
    }
}
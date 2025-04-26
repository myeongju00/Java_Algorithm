class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, count, target);
        return count;
    }
    
    public void dfs(int[] numbers, int idx, int sum, int target) {
        if(idx == numbers.length) {
            if(sum == target) {
                count++;
            }
        } else {
            dfs(numbers, idx + 1, sum + numbers[idx], target);
            dfs(numbers, idx + 1, sum - numbers[idx], target);
        }
    }
}
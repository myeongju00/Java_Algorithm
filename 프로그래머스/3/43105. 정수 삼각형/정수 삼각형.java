class Solution {
    int[][] dp;
    public int solution(int[][] triangle) {
        dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++){
            dp[i][0] = triangle[i][0] + dp[i-1][0];
            
            for(int j = 1; j < i + 1; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }
        
        int max = 0;
        for(int i = 0; i < triangle.length; i++){
            if(dp[triangle.length-1][i] > max) {
                max = dp[triangle.length-1][i];
            }
        }    
        
        return max;
    }
}
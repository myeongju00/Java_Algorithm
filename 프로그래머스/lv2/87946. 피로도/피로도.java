class Solution {
    static int answer = -1;
    static int[][] dungeons;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        Solution.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        
        dfs(0, k);
        
        return answer;
    }
    
    public void dfs(int depth, int k) {
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(depth + 1, k - dungeons[i][1]);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
}
import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++) {
            List<List<Integer>> tempGraph = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                tempGraph.add(new ArrayList<>());
            }
            for(int j = 0; j < wires.length; j++) {
                if(i == j) continue;
                int a = wires[j][0] - 1;
                int b = wires[j][1] - 1;
                tempGraph.get(a).add(b);
                tempGraph.get(b).add(a);
            }
            int count = bfs(tempGraph, n, 0);
            
            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    public int bfs(List<List<Integer>> graph, int n, int start) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        
        visited[start] = true;
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int next : graph.get(now)) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> { return o1[1]-o2[1]; });
        
        int end = targets[0][1]; //끝점
        answer++;
        
        for(int[] target : targets){
            if(target[0] >= end){
                end = target[1];
                // 시점이 요격 시스템의 상한보다 오른쪽에 있기 때문에 새로운 요격 시스템 추가
                answer++; 
            }
        }
        
        return answer;
    }
}
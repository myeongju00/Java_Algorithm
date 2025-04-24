import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int [] first = {1,2,3,4,5};
        int [] second = {2,1,2,3,2,4,2,5};
        int [] third = {3,3,1,1,2,2,4,4,5,5};
        int [] scoreList = {0,0,0};
        ArrayList<Integer> result = new ArrayList<>();
        int maxScore = 0;
        for(int i= 0; i < answers.length; i++) {
            if(answers[i] == first[i % first.length]) scoreList[0]++;
            if(answers[i] == second[i % second.length]) scoreList[1]++;
            if(answers[i] == third[i % third.length]) scoreList[2]++;
            maxScore = Math.max(maxScore, 
                                Math.max(scoreList[0],  
                                         Math.max(scoreList[1], scoreList[2])
                                        )
                               );
        }
        for(int i = 0; i < scoreList.length; i++) {
            if(maxScore == scoreList[i]) {
                result.add(i + 1);
            }
        }
        Collections.sort(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
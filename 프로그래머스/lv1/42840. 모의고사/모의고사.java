import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int [] first = {1,2,3,4,5};
        int [] second = {2,1,2,3,2,4,2,5};
        int [] third = {3,3,1,1,2,2,4,4,5,5};
        int [] scoreList = {0,0,0};
        for(int i = 0; i < answers.length; i++) {
            int currentAnswer = answers[i];
            if(currentAnswer == first[i % first.length]) scoreList[0]++;
            if(currentAnswer == second[i % second.length]) scoreList[1]++;
            if(currentAnswer == third[i % third.length]) scoreList[2]++;
        }
        int maxScore = Math.max(scoreList[0], Math.max(scoreList[1], scoreList[2]));
        
        ArrayList<Integer> answerArrayList = new ArrayList<>();
        for(int i = 0; i < scoreList.length; i++) {
            if(maxScore == scoreList[i]) {
                answerArrayList.add(i + 1);
            }
        }
        
        int[] answer = new int[answerArrayList.size()];
        for(int i =0; i < answerArrayList.size(); i++) {
            answer[i] = answerArrayList.get(i);
        }
        return answer;
    }
}
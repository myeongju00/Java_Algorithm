class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        if(num % 2 == 1) {
            int mid = total / num;
            for(int i = 0; i < num; i++) {
                answer[i] = mid - (num / 2) + i;
            }
        } else {
            int mid = total / num + 1;
            for(int i = 0; i < num; i++) {
                answer[i] = mid - (num / 2) + i;
            }
        }
        return answer;
    }
}
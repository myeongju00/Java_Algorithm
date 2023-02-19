class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        for (int i = 1; i < s.length(); i++) {
            int index = s.lastIndexOf(s.charAt(i), i - 1);
            if(index != -1) {
                answer[i] = i - index;
            } else {
                answer[i] = index;
            }
        }
        return answer;
    }
}
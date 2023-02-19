import java.util.Stack;

class Solution {
    public static int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        //1, 2, 3 순서대로 빵, 야채, 고기
        for(int i : ingredient) {
            stack.push(i);

            if(stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size - 4) == 1 &&
                        stack.get(size - 3) == 2 &&
                        stack.get(size - 2) == 3 &&
                        stack.get(size - 1) == 1) {
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return answer;
    }
}
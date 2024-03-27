import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long q1Sum = 0L, q2Sum = 0L;

        for (int i = 0; i < queue1.length; i++) {
            q1Sum += queue1[i];
            q1.add(queue1[i]);

            q2Sum += queue2[i];
            q2.add(queue2[i]);
        }

        while (q1Sum != q2Sum) {
            if(answer > (queue1.length +  queue2.length) * 2) {
                return -1;
            }
            int number = 0;
            if(q1Sum < q2Sum) {
                number = q2.poll();
                q1.add(number);
                q2Sum -= number;
                q1Sum += number;
            }
            else if (q1Sum > q2Sum) {
                number = q1.poll();
                q2.add(number);
                q1Sum -= number;
                q2Sum += number;
            } else {
                return answer;
            }
            answer++;
        }

        return answer;
    }
}
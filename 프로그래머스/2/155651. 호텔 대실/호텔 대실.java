import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] time = new int[book_time.length][2];

        for (int i = 0; i < book_time.length; i++) {
            int startTime = Integer.parseInt(book_time[i][0].replace(":", ""));
            int endTime = Integer.parseInt(book_time[i][1].replace(":", ""));

            endTime += 10;
            if (endTime % 100 >= 60) {
                endTime += 40;
            }
            time[i][0] = startTime;
            time[i][1] = endTime;
        }

        Arrays.sort(time, (o1, o2) -> {
            if (o1[0] == o2[0])  {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];

            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //peek()가 다음 시작 시간보다 클 경우 add 
        // 만약 peek가 더 작을 경우 같은 방을 사용할 수 있으므로 poll후 add
        for(int[] timeTemp : time){
            if(queue.isEmpty()){
                queue.add(timeTemp[1]);
                continue;
            }
            if ((queue.peek()) <= timeTemp[0]) {
                queue.poll();
                queue.add(timeTemp[1]);
            } else {
                
                queue.add(timeTemp[1]);
            }
        }

        return queue.size();
    }
}
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        ArrayList<Integer> reserveList = new ArrayList<>();
        for (int reserveNumber : reserve) {
            reserveList.add(reserveNumber);
        }

        ArrayList<Integer> lostList = new ArrayList<>();
        for (int lostNumber : lost) {
            lostList.add(lostNumber);
        }

        // 여벌 체육복을 가져온 학생이 도난당한 경우 먼저 처리
        for (int i = 0; i < lostList.size(); ) {
            if (reserveList.contains(lostList.get(i))) {
                reserveList.remove(lostList.get(i));
                lostList.remove(i);
                answer++;
            } else {
                i++;
            }
        }

        // 여벌 체육복을 가져온 학생이 도난당하지 않은 경우 처리
        for (int lostNumber : lostList) {
            for (int i = -1; i <= 1; i += 2) {
                if (reserveList.contains(lostNumber + i)) {
                    reserveList.remove((Integer) (lostNumber + i));
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}

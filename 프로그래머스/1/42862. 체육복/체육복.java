import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        ArrayList<Integer> reserveList = new ArrayList<>();
        ArrayList<Integer> lostList = new ArrayList<>();
        for(int i : reserve) {
            reserveList.add(i);
        }

        for(int i : lost) {
            lostList.add(i);
        }

        for(int lostMember : lost) {
            if(reserveList.contains(lostMember)) {
                reserveList.remove(Integer.valueOf(lostMember));
                lostList.remove(Integer.valueOf(lostMember));
                answer++;
            }
        }
        
        for(int lostMember : lostList) {
            if(reserveList.isEmpty()) {
                break;
            }
            // 여벌 체육복 있는 애가 도난
            if(lostMember - 1 > 0 && reserveList.contains(lostMember - 1)) {
                reserveList.remove(Integer.valueOf(lostMember - 1));
                answer++;
            } else if (lostMember + 1 <= n && reserveList.contains(lostMember + 1)) {
                reserveList.remove(Integer.valueOf(lostMember + 1));
                answer++;
            }
        }

        return answer;
    }
}
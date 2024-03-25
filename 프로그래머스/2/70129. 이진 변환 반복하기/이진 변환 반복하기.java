class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int loops = 0;
        while(!s.equals("1")) {
            int zeroCount = countZero(s);
            cnt += zeroCount;
            loops++;

            int oneCount = s.length() - zeroCount;
            s = Integer.toString(oneCount, 2);

        }
        return new int[]{loops, cnt};
    }

    private int countZero(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') cnt++;
        }
        return cnt;
    }
}
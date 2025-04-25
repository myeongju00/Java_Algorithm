public class Solution {
    public int solution(int n, long l, long r) {
        return (int) countOnes(n, 0, (long) Math.pow(5, n) - 1, l - 1, r - 1);
    }

    private long countOnes(int level, long start, long end, long l, long r) {
        // 현재 구간이 탐색 구간 [l, r]과 겹치지 않으면 종료
        if (r < start || l > end) return 0;

        // 완전히 포함되면 최적화된 값으로 계산
        if (l <= start && end <= r) {
            return countTotalOnes(level);
        }

        // 더 쪼개서 탐색
        long len = (end - start + 1) / 5;
        long total = 0;

        for (int i = 0; i < 5; i++) {
            // 가운데(3번째) 구간은 항상 0 → 스킵
            if (i == 2) continue;

            long subStart = start + len * i;
            long subEnd = subStart + len - 1;

            total += countOnes(level - 1, subStart, subEnd, l, r);
        }

        return total;
    }

    private long countTotalOnes(int level) {
        if (level == 0) return 1;         // base case: "1"
        return 4 * countTotalOnes(level - 1); // 1 → 11011 → 4개의 1
    }
}
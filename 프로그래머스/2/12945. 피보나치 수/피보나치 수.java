class Solution {
    public int solution(int n) {
        int[] pibonacci = new int[n + 1];
        pibonacci[0] = 0;
        pibonacci[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            pibonacci[i] = (pibonacci[i - 1] + pibonacci[i - 2]) % 1234567;
        }
        
        return pibonacci[n];
    }
}
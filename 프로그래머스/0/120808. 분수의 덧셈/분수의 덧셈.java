class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer = numer1 * denom2 + denom1 * numer2;
        int denom = denom1 * denom2;
        
        int gcdNumber = gcd(numer, denom);
        int[] answer = {numer / gcdNumber, denom / gcdNumber};
        return answer;
    }
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
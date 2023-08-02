class Solution {
    public int solution(int a, int b) {
        
        String str = String.valueOf(a) + String.valueOf(b);
        int num = 2 * a * b;
        
        return Integer.parseInt(str) < num ? num : Integer.parseInt(str);
    }
}
class Solution {
    public int solution(int a, int b) {
        String str1 = String.valueOf(a) + String.valueOf(b);
        String str2 = String.valueOf(b) + String.valueOf(a);
        
        if(Integer.parseInt(str1) > Integer.parseInt(str2)) {
            return Integer.parseInt(str1);
        }
        
        return Integer.parseInt(str2);
    }
}
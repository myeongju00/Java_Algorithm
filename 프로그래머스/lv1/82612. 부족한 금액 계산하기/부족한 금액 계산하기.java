class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long totalPrice = 0;
        for (int i = 1; i <= count; i++) {
            totalPrice += i * price;
        }
        answer = totalPrice - money;
        
        if (answer < 0) return 0;
        
        return answer;
    }
}
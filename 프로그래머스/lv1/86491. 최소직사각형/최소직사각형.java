class Solution {
    public int solution(int[][] sizes) {
        int walletX = 0, walletY = 0;
        
        for(int[] size : sizes) {
            walletX = Math.max(walletX, Math.max(size[0], size[1]));
            walletY = Math.max(walletY, Math.min(size[0], size[1]));
        }
        
        return walletX * walletY;
    }
}
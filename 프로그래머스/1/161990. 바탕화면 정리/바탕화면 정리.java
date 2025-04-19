class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;
        
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, j);
                    luy = Math.min(luy, i);
                    rdx = Math.max(rdx, j + 1);
                    rdy = Math.max(rdy, i + 1);
                }
            }
        }
        return new int[] {luy, lux, rdy, rdx};
    }
}
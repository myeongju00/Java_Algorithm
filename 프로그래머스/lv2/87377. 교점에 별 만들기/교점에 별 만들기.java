import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        
        ArrayList<long[]> dots = new ArrayList<>();
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        
        
        for(int i = 0; i < line.length - 1; i++) {
            long A = line[i][0];
            long B = line[i][1];
            long E = line[i][2];
            
            for(int j = i + 1; j < line.length; j++) {
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];
                
                long mod = A * D - B * C;
                if(mod == 0) continue;
                
                long topX = (B * F - E * D);
                if(topX % mod != 0) continue;
                                
                long topY = (E * C - A * F);
                if(topY % mod != 0) continue;
                
                long x = topX / mod;
                long y = topY / mod;
                
                dots.add(new long[] {x, y});
                
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
            }
        }
        
        
        
        boolean[][] answerTemp = new boolean[(int) (maxY- minY +1)][(int) (maxX - minX + 1)];

        for (long[] ints : dots) {
            int x = (int) (ints[0] - minX);
            int y = (int) (ints[1] - maxY);

            answerTemp[Math.abs(y)][Math.abs(x)] = true;
        }

        answer = new String[answerTemp.length];

        int i = 0;
        for (boolean[] bs : answerTemp) {
            StringBuilder sb = new StringBuilder();
            for (boolean b : bs) {
                if (b) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }
            answer[i] = sb.toString();
            i++;
        }
        return answer;
    }
}
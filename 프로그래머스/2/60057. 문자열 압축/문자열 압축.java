class Solution {
    public int solution(String s) {
        int len = s.length();
        int ans = s.length();

        for(int i = 1; i <= s.length() / 2 ; i++) {
            StringBuilder sb = new StringBuilder();
            String delim = s.substring(0, i);

            int cnt = 1; // 문자 출현 횟수
            int start = i;
            
            while(start < len) {
                if(s.substring(start, len).startsWith(delim)) {
                    cnt++;
                }
                else { 
                    if(cnt == 1) {
                        sb.append(delim);
                    } else {
                        sb.append(cnt).append(delim);
                    }
                    
                    cnt = 1;
                    delim = start + i < len ? s.substring(start, start + i) : s.substring(start, len);
                }
                
                start += i;
                
            }
            
            if(cnt == 1)  {
                sb.append(delim);
            } else { 
                sb.append(cnt).append(delim);
            }
            
            ans = Math.min(ans, sb.toString().length());
        }
        return ans;
    }
}
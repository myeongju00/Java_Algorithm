import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        // {{ 제거
        s = s.substring(2);
        // }} 를 제거, },{ 형태의 문자열을 -로 변환
        s = s.substring(0,s.length()-2).replace("},{","-");

        String str[] = s.split("-");
        Arrays.sort(str, (o1, o2) -> o1.length() - o2.length());

        for (String st : str) {
            String[] temp = st.split(",");
            for (String t : temp) {
                int num = Integer.parseInt(t);
                if (!answer.contains(num))  {
                    answer.add(num);
                }
            }
        }

        return answer;
    }
}
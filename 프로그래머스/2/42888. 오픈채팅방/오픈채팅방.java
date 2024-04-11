import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {

        HashMap<String, String> map = new HashMap<>();
        int cnt = 0;
        for(String r : record) {
            String[] recordSplit = r.split(" ");
            if (recordSplit[0].equals("Enter") || recordSplit[0].equals("Change")) {
                map.put(recordSplit[1], recordSplit[2]);
                cnt++;
            }
        }

        ArrayList<String> answer = new ArrayList<>();

        for(String r : record) {
            StringBuilder sb = new StringBuilder();
            String[] recordSplit = r.split(" ");
            if (recordSplit[0].equals("Enter")) {
                sb.append(map.get(recordSplit[1])).append("님이 들어왔습니다.");
            } else if (recordSplit[0].equals("Leave")) {
                sb.append(map.get(recordSplit[1])).append("님이 나갔습니다.");
            } else {
                continue;
            }
            answer.add(sb.toString());
        }
        return answer.toArray(String[]::new);
    }
}
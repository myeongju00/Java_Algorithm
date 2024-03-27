class Solution {
    public String solution(String new_id) {
        String answer = "";
        // step 1
        answer = new_id.toLowerCase();

        //step 2
        answer = answer.replaceAll("[^a-z0-9\\-_.]", "");

        //step 3
        answer = answer.replaceAll("\\.+", ".");

        //step 4
        answer = answer.replaceAll("^\\.+|\\.+$", "");

        //step 5
        if (answer.isEmpty()) answer = "a";

        //step 6
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

        //step 7
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }
        return answer;
    }
}
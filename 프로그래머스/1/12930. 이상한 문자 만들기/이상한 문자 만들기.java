class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();

        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == ' ') {
                idx = 0;
                continue;
            }
            if(idx % 2 == 0) {
                arr[i] = Character.toUpperCase(arr[i]);
            } else {
                arr[i] = Character.toLowerCase(arr[i]);
            }
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}
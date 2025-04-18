class Solution {
    String[] list = {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        int answer = 0;
    
        for(String word : babbling){
            for(String li : list){
                if(word.contains(li)){
                    word = word.replace(li, " ");
                }
            }
            word = word.replace(" ", "");
            if(word.equals(""))  {
                answer++;
            }
        }
        
        return answer;
    }
}
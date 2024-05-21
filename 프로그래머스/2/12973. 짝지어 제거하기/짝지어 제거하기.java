import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(char a : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == a){
                stack.pop();
            } else stack.push(a);
        } 
        return stack.isEmpty()? 1 : 0;
    }
}
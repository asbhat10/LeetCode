class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int invalid = -1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                    int end = stack.isEmpty()?invalid:stack.peek();
                    max = Math.max(max,i-end);
                }else{
                    invalid = i;
                }
            }
        }
        
        return max;
    }
}
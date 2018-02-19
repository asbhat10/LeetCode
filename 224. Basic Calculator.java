class Solution {
    public int calculate(String s) {
        int sign = 1;
        Stack<Integer> nums = new Stack<>();
        int result = 0;
        int cur = 0;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i)))
                cur = (cur*10)+(s.charAt(i)-'0');
            else if(s.charAt(i) == '+'){
                result += (sign*cur);
                cur = 0;
                sign = 1;
            }else if(s.charAt(i) == '-'){
                result += sign*cur;
                cur = 0;
                sign = -1;
            }else if(s.charAt(i) == '('){
                nums.push(result);
                nums.push(sign);
                result = 0;
                sign = 1;
                cur = 0;
            }else if(s.charAt(i) == ')'){
                result += (sign*cur);
                result *= nums.pop();
                result +=nums.pop();
                cur = 0;
                sign = 1;
            }
        }
        
        return result+(sign*cur);
    }
}
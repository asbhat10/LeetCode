class Solution {
    public String shortestPalindrome(String s) {
        StringBuffer prefix = new StringBuffer();
        for(int i=0;i<s.length()-1;i++){
            int temp = i;

            if(isPalindrome(s.substring(0,s.length()-i)))
                break;
            prefix.append(s.charAt(s.length()-i-1));
        }

        return prefix.toString()+s;
    }

    private boolean isPalindrome(String sub){
        int temp = 0;
        while(temp<sub.length()/2){
            if(sub.charAt(temp) != sub.charAt(sub.length()-temp-1))
                break;
            temp++;
        }
        return temp==sub.length()/2;
    }
}

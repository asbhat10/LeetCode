public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() == 0){
            return  0;
        }
        String[] split = s.split(" ");
        return split[split.length-1].length();
    }
}
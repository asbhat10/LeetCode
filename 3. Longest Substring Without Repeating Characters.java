public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int curLength = 1;
        
        if(s.length() == 0){
            return 0;
        }
        int[] strIndex = new int[256];
        for(int i=0;i<256;i++){
            strIndex[i] = -1;
        }
        strIndex[(int)s.charAt(0)] = 0;
        for(int j=1;j<s.length();j++){
            //System.out.println((int)s.charAt(j));
            if(strIndex[(int)s.charAt(j)] == -1 || (j-strIndex[(int)s.charAt(j)]) > curLength){
                curLength += 1;
                strIndex[(int)s.charAt(j)] = j;
                if(curLength > maxLength){
                    maxLength = curLength;
                }
            }else{
                if(curLength > maxLength){
                    maxLength = curLength;
                }
                curLength = j - strIndex[(int)s.charAt(j)];
                strIndex[(int)s.charAt(j)] = j;
                //System.out.println(curLength);
            }
            
        }
        if(maxLength == 0){
            maxLength = curLength;
        }
        return maxLength;
    }
}
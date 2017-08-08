public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        if(numRows == 1){
            return s;
        }
        for(int i=0;i<numRows;i++){
            int j = i;
            int k = ((numRows-1)*2) - i;
            boolean kvar = true;
            if(k== (numRows-1)*2 || j ==k || k<numRows){
                kvar = false;
            }
            while(j < s.length()){
                sb.append(s.charAt(j));
                if(k < s.length() && kvar){
                    sb.append(s.charAt(k));
                    k += (numRows-1)*2;
                }
                j += (numRows-1)*2;
                
            }
        }
        return sb.toString();
    }
}
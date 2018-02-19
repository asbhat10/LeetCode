class Solution {
    public boolean isMatch(String s, String p) {
        if(p.equals("*")) return true;
        int lastMatch = 0;
        int snum = 0;
        int pnum = 0;
        int star = -1;
        while(snum < s.length()){
            if(pnum < p.length() && (s.charAt(snum) == p.charAt(pnum) || p.charAt(pnum) == '?')){
                snum++;
                pnum++;
            }else if(pnum < p.length() && p.charAt(pnum) == '*'){
                star = pnum;
                lastMatch = snum;
                pnum++;
                
            }else if(star != -1){
                
                pnum = star+1;
                lastMatch++;
                snum = lastMatch;
            }else{
                return false;
            }
        }
        while(pnum<p.length() && p.charAt(pnum)=='*')
            pnum++;
        return pnum == p.length();
    }
}
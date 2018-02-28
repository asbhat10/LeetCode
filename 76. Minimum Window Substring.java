class Solution {
    public String minWindow(String s, String t) {
        if(t.length() == 0 || s.length() == 0)
            return  "";

        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int minStart = 0;
        int end = 0;
        int curLen = 0;

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),0);
        }

        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i)))
                return "";
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        //System.out.println(map);
        while(end < s.length()){
            if(map.get(s.charAt(end)) > 0){
                curLen++;
            }
            map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0)-1);
            end++;

            while(start <= end && curLen == t.length()){
                if(end-start < minLen){
                    minLen = end-start;
                    minStart = start;
                }
                char curStart = s.charAt(start);
                start++;
                // System.out.println(map);

                if(map.get(curStart) == 0){
                    curLen--;
                }
                map.put(curStart,map.get(curStart)+1);
            }
        }

        return minLen == Integer.MAX_VALUE?"":s.substring(minStart,minStart+minLen);
    }
}

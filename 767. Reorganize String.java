class Solution {
    public String reorganizeString(String S) {
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0;i<S.length();i++){
            map.put(S.charAt(i),map.getOrDefault(S.charAt(i),0)+1);
            max = Math.max(max,map.get(S.charAt(i)));
        }

        if(max >(S.length()+1)/2)
            return "";
        if(map.size() == S.length())
            return S;
        StringBuilder sb = new StringBuilder();
        while(map.size()>0){
            for(char c:map.keySet()){
                sb.append(c+"");
                map.put(c,map.get(c)-1);
                if(map.get(c) == 0)
                    map.remove(c);
            }
        }
        return sb.toString();
    }
}

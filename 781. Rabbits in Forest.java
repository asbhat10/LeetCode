class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<answers.length;i++){
            if(answers[i] == 0)
                res++;
            else{
                int count = map.getOrDefault(answers[i],0)+1;
                if(count == answers[i]+1){
                    res += count;
                    map.remove(answers[i]);
                }else{
                    map.put(answers[i],count);
                }
            }
            
        }
        
        for (Integer key : map.keySet()) {
            res += key+1;
        }
        
        return res;
    }
}
class Solution {
    public int minSwapsCouples(int[] row) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<row.length-1;i=i+2){
            map.put(row[i],row[i+1]);
            map.put(row[i+1],row[i]);
        }
        int count = 0;        
        for(int i=0;i<row.length-1;i=i+2){
            if(map.get(i) != i+1){
                int cur = map.get(i);
                int correctIndex = map.get(i+1);
                map.put(cur,correctIndex);
                map.put(correctIndex,cur);              
                count++;
            }
        }
        return count;
    }
}
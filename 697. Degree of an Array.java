class Solution {
    public int findShortestSubArray(int[] nums) {
        int degree = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,List<Integer>> indexMap= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            degree = Math.max(degree,map.get(nums[i]));
            List<Integer> list = indexMap.getOrDefault(nums[i],new ArrayList<Integer>());
            list.add(i);
            indexMap.put(nums[i],list);
        }
        if(map.size() == nums.length){
            return 1;
        }
        int min = Integer.MAX_VALUE;
        
        for(int key:map.keySet()){
            if(map.get(key) >= degree){
                
                List<Integer> list = indexMap.get(key);
                //System.out.println("Here :"+key+"   "+list.size());
                for(int i=0;i<=list.size()-degree;i++){
                    min = Math.min(min,list.get(i+degree-1)-list.get(i)+1);
                }
            }
        }
        
        return min;
        
    }
}
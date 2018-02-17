class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if(n == 1)
            return new ArrayList<Integer>() {{add(0);}};
        
        Map<Integer,HashSet<Integer>> map = new HashMap<>();
        for(int[] nums:edges){
            HashSet<Integer> set = map.get(nums[0]) == null?new HashSet<>():map.get(nums[0]);
            set.add(nums[1]);
            map.put(nums[0],set);
            set = map.get(nums[1]) == null?new HashSet<>():map.get(nums[1]);
            set.add(nums[0]);
            map.put(nums[1],set);
        }
        List<Integer> leaves = new ArrayList<>();
        
        for(int key: map.keySet()){
            //System.out.println(map.get(key).size()+"   "+key);
            if(map.get(key).size() == 1){
                leaves.add(key);
            }
        }
        while(n >2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf:leaves){
                //System.out.println(leaf+"   "+leaves.size());
                for(int node:map.get(leaf)){
                    HashSet<Integer> set = map.get(node);
                    set.remove(leaf);
                    if(set.size() == 1)
                        newLeaves.add(node);
                }
                
            }
            leaves = newLeaves;
        }
        
        
        
        return leaves;
    }
}
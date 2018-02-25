class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2)
            return 0;
        int maxGap = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            // Integer lower = set.lower(nums[i]);
            // Integer higher = set.higher(nums[i]);
            // maxGap = lower == null?maxGap:Math.max(maxGap,nums[i]-lower);
            // maxGap = higher == null?maxGap:Math.max(maxGap,higher - nums[i]);
            set.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            Integer lower = set.lower(nums[i]);
            Integer higher = set.higher(nums[i]);
            maxGap = lower == null?maxGap:Math.max(maxGap,nums[i]-lower);
            maxGap = higher == null?maxGap:Math.max(maxGap,higher - nums[i]);
            set.add(nums[i]);
        }
            
        return maxGap;
    }
}
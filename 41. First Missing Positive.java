class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        if(length==0) return 1;
        for(int i=0;i<length;i++){
            while(nums[i] >0 && nums[i]<=length && nums[i] != nums[nums[i] -1]){
                
                int temp = nums[i];
                nums[i] = nums[nums[i] -1];
                nums[temp -1] = temp;
            }
        }
        
        for(int i=0;i<length;i++){
            //System.out.println(nums[i]);
            if(nums[i] != i+1)
                return i+1;
        }
        
        return length+1;
    }

}
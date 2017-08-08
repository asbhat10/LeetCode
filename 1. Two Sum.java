public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        
        for(int i=0;i<nums.length;i++){
            int j=nums.length-1;
            while(i<j){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }else{
                    j--;
                }
            }
        }
        return result;
    }
}
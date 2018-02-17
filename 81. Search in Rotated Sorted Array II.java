class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        return binarySearch(nums,target,start,end);
    }
    
    public boolean binarySearch(int[] nums, int target,int start, int end){
        if(start > end) return false;
        while(start <= end){
            
            int mid = start +((end-start)/2);
            //System.out.println("Here "+nums[mid]);
            if(nums[mid] == target) return true;
            if(nums[start] < nums[end]){
                if(nums[mid] < target){
                    return binarySearch(nums,target,mid+1,end);
                }else{
                    return binarySearch(nums,target,start,mid-1);
                }
            }else{
                return binarySearch(nums,target,start,mid-1) || binarySearch(nums,target,mid+1,end);
            }
        }
        
        return false;
    }
}
class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length==0 || nums2.length == 0) return new ArrayList<int[]>();
        int[] index = new int[nums1.length];
        List<int[]> res = new ArrayList<>();
        int sum = Integer.MAX_VALUE;
        int curx = 0;
        int cury = 0;
        int count = 0;
        
        while(count <k && count <nums1.length*nums2.length){
            for(int i=0;i<nums1.length;i++){
                if(index[i] < nums2.length && nums1[i]+nums2[index[i]] < sum){
                    curx = i;
                    cury = index[i];
                    sum = nums1[i]+nums2[index[i]];
                }
            }
            res.add(new int[]{nums1[curx],nums2[cury]});
            count++;
            for(int i=0;i<nums1.length;i++){
                if(index[i] < nums2.length && nums1[i]+nums2[index[i]] < sum){
                    index[i]++;
                }else if(index[i] < nums2.length && nums1[i]+nums2[index[i]] == sum && i == curx){
                    index[i]++;
                }
            }
            sum = Integer.MAX_VALUE;
        }
        
        return res;
    }
}
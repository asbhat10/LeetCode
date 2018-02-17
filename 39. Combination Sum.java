class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res,candidates,target,new ArrayList<>(),0);
        
        return res;
    }
    
    public void backtrack(List<List<Integer>> res,int[] candidates, int target, ArrayList<Integer> cur,int start){
        if(target <0) return;
        if(target == 0)
            res.add(new ArrayList<>(cur));
        else{
            for(int i=start;i<candidates.length;i++){
                cur.add(candidates[i]);
                backtrack(res,candidates,target-candidates[i],cur,i);
                cur.remove(cur.size()-1);
            }
        }
    }
}
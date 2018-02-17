class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates,result,new ArrayList<Integer>(),target,0);
        return result;
    }
    
    public void backtrack(int[] candidates, List<List<Integer>> result,List<Integer> cur, int target,int start){
        if(target < 0) return;
        if(target == 0)
            result.add(new ArrayList<Integer>(cur));
        else{
            for(int i=start;i<candidates.length;i++){
                if (i > start && candidates[i] == candidates[i-1]) continue;
                cur.add(candidates[i]);
                backtrack(candidates,result,cur,target-candidates[i],i+1);
                cur.remove(cur.size()-1);
            }
        }
    }
}
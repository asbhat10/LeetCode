class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(k==0 || n==0)
            return result;
        backtrack(k,n,result,new ArrayList<Integer>(), 0,0);
        return result;
    }
    
    public void backtrack(int k,int n, List<List<Integer>> result,List<Integer> list,int sum,int start){
        if(list.size() == k){
            if(sum == n)
                result.add(new ArrayList<>(list));
            return;
        }
            
        for(int i=start+1;i<=9;i++){
            if(list.contains(i)) continue;
            list.add(i);
            backtrack(k,n,result,list, sum+i,i);
            list.remove(list.size()-1);
        }
        
    }
}
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               return a[1]-b[1];
           } 
        });
        
        List<Integer> res = new ArrayList<>();
        res.add(intervals[0][1]-1);
        res.add(intervals[0][1]);
        for(int i=1;i<intervals.length;i++){
            int lastButOne = res.get(res.size()-2);
            int last = res.get(res.size()-1);
            
            if(lastButOne >= intervals[i][0] && last <= intervals[i][1])
                continue;
            if(last<intervals[i][0]){
                res.add(intervals[i][1]-1);
                res.add(intervals[i][1]);
            }else if(lastButOne<intervals[i][0]){
                res.add(intervals[i][1]);
            }
        }
        
        return res.size();
    }
}
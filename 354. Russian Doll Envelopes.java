class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0) return 0;
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<envelopes.length;i++)
            list.add(new int[]{envelopes[i][0],envelopes[i][1]});
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                // if(a[0] != b[0])
                //     return b[0]-a[0];
                return b[0]*b[1]-a[0]*a[1];
            }
        });
        
        int[] dp = new int[list.size()];
        Arrays.fill(dp,1);
        int max = 1;
        
        for(int i=1;i<list.size();i++){
            int[] cur = list.get(i);
            for(int j=0;j<i;j++){
                int[] temp = list.get(j);
                if(temp[0] > cur[0] && temp[1] > cur[1]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                    max = Math.max(dp[i],max);
                }
            }
        }
        
        return max;
    }
}
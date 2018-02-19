class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] matrix = new int[n][n];
        int[] cost = new int[n];
        for(int i=0;i<n;i++){
            Arrays.fill(matrix[i],Integer.MAX_VALUE);
        }
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src] = 0;
        for(int i=0;i<flights.length;i++){
            matrix[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new  HashSet<>();
        
        q.add(src);
        visited.add(src);
        while(k>=0){
            int size = q.size();
            while(size >0){
                int cur = q.poll();
                for(int i=0;i<n;i++){
                    if(i==cur || matrix[cur][i] ==Integer.MAX_VALUE ) continue;
                    if(cost[i] > cost[cur] + matrix[cur][i]){                       
                        q.add(i);
                        cost[i] = cost[cur] + matrix[cur][i];
                    }
                        
                }
                size--;
            }
            k--;
        }
        
        
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] matrix = new int[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(matrix[i],Integer.MAX_VALUE);
        }
        
        for(int[] time:times){
            matrix[time[0]-1][time[1]-1] = time[2];
        }
        HashSet<Integer> visited = new HashSet<>();
        
        int[] res = new int[N];
        
        
        Arrays.fill(res,Integer.MAX_VALUE);
        res[K-1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(K-1);
        visited.add(K-1);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int cur = queue.poll();
                
                //System.out.println(cur);
                for(int j=0;j<N;j++){
                    if(matrix[cur][j] == Integer.MAX_VALUE) continue;
                    res[j] = Math.min(res[j],res[cur]+matrix[cur][j]);
                    //System.out.println(cur+"   "+j+"   "+res[j]+"   "+matrix[cur][j]);
                    if(!visited.contains(j)){
                        queue.offer(j);
                        visited.add(j);
                    }
                    
                }
            }
        }
        while(true){
            int temp[] = new int[N];
            temp = res.clone();
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j || matrix[i][j]==Integer.MAX_VALUE) continue;
                    res[j] = Math.min(res[j],res[i]+matrix[i][j]);
                }
            }
            if(Arrays.equals(temp,res))
                break;
        }
        
        
        int max = 0;
        for(int i=0;i<N;i++){
            //System.out.print(res[i]+"  ");
            max = Math.max(max,res[i]);
        }
        
        return max == Integer.MAX_VALUE?-1:max;
    }
}
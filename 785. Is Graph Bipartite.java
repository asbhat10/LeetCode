class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] nodes = new int[len];
        Arrays.fill(nodes,-1);
        
        for(int i=0;i<len;i++){
            if(nodes[i]==-1)
                if(!dfs(graph,nodes,i,0))
                    return false;
        }
        
        return true;
    }
    
    public boolean dfs(int[][] graph, int[] nodes, int cur, int color){
        if(nodes[cur]!=-1) return nodes[cur]==color;
        nodes[cur] = color;
        for(int next:graph[cur]){
            if(!dfs(graph,nodes,next,1-color))
                return false;
        }
        return true;
    }
}
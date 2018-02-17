class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        
        if(matrix.length == 0){
            return result;
        }
        int rows = matrix.length-1;
        int cols = matrix[0].length-1;
        
        boolean[][] atlantic = new boolean[rows+1][cols+1];
        boolean[][] pacific = new boolean[rows+1][cols+1];
        
        for(int i=0;i<=rows;i++){
            dfs(matrix,pacific,i,0,Integer.MIN_VALUE);
            dfs(matrix,atlantic,i,cols,Integer.MIN_VALUE);
            
        }
        for(int i=0;i<=cols;i++){
            dfs(matrix,pacific,0,i,Integer.MIN_VALUE);
            dfs(matrix,atlantic,rows,i,Integer.MIN_VALUE);
        }
        
        for(int i=0;i<=rows;i++){
            for(int j=0;j<=cols;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(new int[]{i,j});
                }
            }
        }
        
        return result;
        
    }
    
    private void dfs(int[][] matrix,boolean[][] cur,int i,int j,int height){
        if(i>=matrix.length || i <0 || j>=matrix[0].length || j <0 || matrix[i][j] <height || cur[i][j] ) return;
        cur[i][j] = true;
        dfs(matrix,cur,i-1,j,matrix[i][j]);
        dfs(matrix,cur,i+1,j,matrix[i][j]);
        dfs(matrix,cur,i,j+1,matrix[i][j]);
        dfs(matrix,cur,i,j-1,matrix[i][j]);
    }
}
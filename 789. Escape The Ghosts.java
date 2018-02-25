class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int targetMoves = Math.abs(target[0])+Math.abs(target[1]);
        int minG = Integer.MAX_VALUE;
        for(int[] g:ghosts){
            minG = Math.min(minG,Math.abs(target[0]-g[0])+Math.abs(target[1]-g[1]));
        }
        //System.out.println(minG+"   "+targetMoves);
        if(minG > targetMoves)
            return true;
        return false;
    }
}

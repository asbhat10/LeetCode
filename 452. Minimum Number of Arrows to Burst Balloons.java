class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        int count = 1;
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0])
                    return a[1]-b[1];
                return a[0]-b[0];
            }
        });
        int start = points[0][0];
        int end = points[0][1];
        
        for(int i=1;i<points.length;i++){
            if(points[i][0] <= end){
                end = Math.min(end,points[i][1]);
            }else{
                count++;
                start = points[i][0];
                end = points[i][1];
            }
        }
        return count;
    }
}
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int len = gas.length;
        for(int i=0;i<len;i++){
            gasSum += gas[i];
            costSum += cost[i];
        }
        if(gasSum < costSum) return -1;
        
        gasSum = 0;
        costSum = 0;
        
        for(int i=0;i<len;i++){
            gasSum = gas[i];
            costSum = cost[i];
            if(gasSum < costSum) continue;
            
            int temp = 1;
            while(temp < len){
                gasSum += gas[(i+temp)%len];
                costSum += cost[(i+temp)%len];
                if(gasSum < costSum){
                    i = (i+temp);
                    break;
                }
                temp++;
            }
            if(temp == len)
                return i;
                
        }
        
        return -1;
    }
}
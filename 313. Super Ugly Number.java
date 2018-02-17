class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglies = new int[n];
        int[] indices = new int[primes.length];
        
        uglies[0] = 1;
        
        for(int i=1;i<n;i++){
            uglies[i] = Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                uglies[i] = Math.min(uglies[i],primes[j]*uglies[indices[j]]);
            }
            
            for(int j=0;j<primes.length;j++){
                if(primes[j]*uglies[indices[j]] <= uglies[i])
                    indices[j]++;
            }
            //System.out.println(uglies[i]);
        }
        
        return uglies[n-1];
    }
}
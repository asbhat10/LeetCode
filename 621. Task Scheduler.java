class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(int i=0;i<tasks.length;i++){
            count[tasks[i]-'A']++;
        }

        Arrays.sort(count);
        int i=24;
        while(count[i] == count[25])
            i--;

        return Math.max(tasks.length,((count[25]-1)*(n+1))+(25-i));
    }
}

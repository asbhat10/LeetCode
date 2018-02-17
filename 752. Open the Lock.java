class Solution {
    // int min = Integer.MAX_VALUE;
    public int openLock(String[] deadends, String target) {
        
        HashSet<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        int count = 0;

        queue.add("0000");
        visited.add("0000");
        while(queue.size() >0){
            int size = queue.size();
            while(size>0){
                String cur = queue.poll();
                if(deadSet.contains(cur)) {
                    size --;
                    continue;
                }
                if(cur.equals(target)) return count;
                for(int i=0;i<4;i++){
                    char c = cur.charAt(i);
                    String next = cur.substring(0,i)+(cur.charAt(i)=='9'? 0 : c - '0' + 1)+cur.substring(i+1);
                    String prev = cur.substring(0,i)+(cur.charAt(i)=='0'? 9 : c - '0' - 1)+cur.substring(i+1);
                    if(!visited.contains(next) && !deadSet.contains(next)){
                        queue.offer(next);
                        visited.add(next);
                    }
                    if(!visited.contains(prev) && !deadSet.contains(prev)){
                        queue.offer(prev);
                        visited.add(prev);
                    }
                
                }
                
                
                size--;
            }
            count++;
        }
        
        return -1;
    }
}
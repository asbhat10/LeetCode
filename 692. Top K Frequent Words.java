class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> countMap = new HashMap<>();
        TreeMap<Integer,TreeSet<String>> buckets = new TreeMap<>(Collections.reverseOrder());
        
        for(String w:words){
            int count = countMap.getOrDefault(w,0)+1;
            countMap.put(w,count);
            TreeSet<String> set = buckets.containsKey(count) ?buckets.get(count):new TreeSet<String>();
            set.add(w);
            buckets.put(count,set);
            if(count != 1){
                Set<String> setTemp = buckets.get(count-1);
                setTemp.remove(w);
            }   
        }
        List<String> res = new ArrayList<>();
        for(int key:buckets.keySet()){
            if(k<=0)
                    break;
            for(String s:buckets.get(key)){
                res.add(s);
                k--;
                if(k==0)
                    break;
            }
        }
        
        return res;
        
    }
}
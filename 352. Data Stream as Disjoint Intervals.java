/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {

    TreeMap<Integer,Integer> map;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        Integer low = map.floorKey(val);
        Integer high = map.ceilingKey(val);

        if(low == null && high == null)
            map.put(val,val);
        else {
            if(low!=null && map.get(low) >= val){
                return;
            }
            if(low!=null && high!= null && map.get(low) == val-1 && high == val+1){
                map.put(low,map.get(high));
                map.remove(high);
            }else if(low!= null && map.get(low) == val-1){
                map.put(low,val);
            }else if(high != null && high == val+1){
                map.put(val,map.get(high));
                map.remove(high);
            }else{
                map.put(val,val);
            }

        }
    }

    public List<Interval> getIntervals() {
        List<Interval> list = new ArrayList<>();
        for(int key:map.keySet()){
            Interval i = new Interval(key,map.get(key));
            list.add(i);
        }
        return list;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
